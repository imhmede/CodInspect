from datetime import datetime
import xml.etree.ElementTree as ET
import json
import os
import pandas as pd
from scipy.stats import percentileofscore

def parse_checkstyle(xml_file_path):
    try:
        tree = ET.parse(xml_file_path)  # Parse the XML file
        root = tree.getroot()  # Get the root element
        errors = []
 
        # Extract file name from the 'file' element in the XML
        for file_element in root.findall('file'):
            file_name = file_element.attrib['name']  # Get the 'name' attribute of the <file> element
 
            for error in file_element.findall('error'):
                errors.append({
                    'file': file_name,  # Add the file name to the error
                    'line': error.attrib['line'],
                    'severity': error.attrib['severity'],
                    'message': error.attrib['message'],
                    'source': error.attrib['source']
                })
        return errors
    except Exception as e:
        print(f"Failed to parse XML: {e}")
        return []
 
 
def parse_pmd(xml_file_path):
    try:
        # Parse the XML file
        tree = ET.parse(xml_file_path)
        root = tree.getroot()
        # Define the namespace for PMD
        namespace = {'pmd': 'http://pmd.sourceforge.net/report/2.0.0'}
        # Extract information about violations
        violations = []
        for file_element in root.findall('pmd:file', namespace):
            file_name = file_element.get('name')
            for violation in file_element.findall('pmd:violation', namespace):
                violations.append({
                    'file': file_name,
                    'beginline': violation.get('beginline'),
                    'endline': violation.get('endline'),
                    'begincolumn': violation.get('begincolumn'),
                    'endcolumn': violation.get('endcolumn'),
                    'rule': violation.get('rule'),
                    'ruleset': violation.get('ruleset'),
                    'class': violation.get('class'),
                    'method': violation.get('method'),
                    'variable': violation.get('variable'),
                    'priority': violation.get('priority'),
                    'message': violation.text.strip() if violation.text else '',
                    'externalInfoUrl': violation.get('externalInfoUrl')
                })
        return violations
    except Exception as e:
        print(f"Failed to parse PMD XML: {e}")
        return []
 
 
def parse_test_results(test_file_path):
    try:
        with open(test_file_path, 'r') as file:
            lines = file.readlines()
 
        # Initialize structure
        result = {
            "testSuite": "",
            "summary": {
                "testsRun": 0,
                "failures": 0,
                "errors": 0,
                "skipped": 0,
                "timeElapsed": ""
            },
            "testCases": []
        }
 
        current_test_case = None
 
        # Parse the file line by line
        for line in lines:
            line = line.strip()
            if line.startswith("Testsuite:"):
                result["testSuite"] = line.split(":")[1].strip()
            elif line.startswith("Tests run:"):
                parts = line.split(", ")
                result["summary"]["testsRun"] = int(parts[0].split(":")[1].strip())
                result["summary"]["failures"] = int(parts[1].split(":")[1].strip())
                result["summary"]["errors"] = int(parts[2].split(":")[1].strip())
                result["summary"]["skipped"] = int(parts[3].split(":")[1].strip())
                result["summary"]["timeElapsed"] = parts[4].split(":")[1].strip()
            elif line.startswith("Testcase:"):
                if current_test_case:
                    result["testCases"].append(current_test_case)
                parts = line.split(" took ")
                test_case_name = parts[0].split(":")[1].strip()
                time_taken = parts[1].strip()
                current_test_case = {
                    "name": test_case_name,
                    "time": time_taken,
                    "status": "PASSED"
                }
            elif line.startswith("FAILED"):
                if current_test_case:
                    current_test_case["status"] = "FAILED"
                    current_test_case["failureDetails"] = {}
            elif line.startswith("expected:") and current_test_case:
                message = line.strip()
                current_test_case["failureDetails"]["message"] = message
            elif line.startswith("at ") and current_test_case:
                if "stackTrace" not in current_test_case["failureDetails"]:
                    current_test_case["failureDetails"]["stackTrace"] = []
                current_test_case["failureDetails"]["stackTrace"].append(line.strip())
 
        # Add the last test case if exists
        if current_test_case:
            result["testCases"].append(current_test_case)
 
        return result
 
    except Exception as e:
        print(f"Failed to parse test results: {e}")
        return {}
def create_json_output(student_name, check_date, checkstyle_errors, pmd_violations, test_results):
    # Combine Checkstyle and PMD violations into a single structure
    output = {
        "System": student_name,
        "checkDate": check_date,
        "violations": {
            "checkstyle": checkstyle_errors,
            "pmd": pmd_violations,
            "Unit testing": test_results
        }
    }
    return output
 
 
# Define the paths to the XML files
checkstyle_file_path = 'build/test-reports/checkstyle-result.xml'
pmd_file_path = 'build/test-reports/pmd.xml'
 
# Directories
test_dir = "test"
reports_dir = "build/test-reports"
 
# Ensure the reports directory exists
os.makedirs(reports_dir, exist_ok=True)
 
# Get the first (and only) file in the test directory
test_files = os.listdir(test_dir)
if not test_files:
    print("No test file found in the 'test' directory.")
    exit(1)  # Exit with an error if no file exists
 
test_file = test_files[0]  # Since there's only one file
file_name, _ = os.path.splitext(test_file)  # Extract filename without extension
 
# Construct the new report filename
new_filename = f"TEST-{file_name}.txt"
test_file_path = os.path.join(reports_dir, new_filename)
 
#test_file_path = "build/test-reports/TEST-TestCases.txt"
print("test_file_path: ", test_file_path)
 
# Parse the Checkstyle XML file
checkstyle_errors = parse_checkstyle(checkstyle_file_path)
 
# Print the parsed Checkstyle errors to the console
if checkstyle_errors:
    print("Checkstyle Errors:")
    for error in checkstyle_errors:
        print(f"File: {error['file']}, Line: {error['line']}, Severity: {error['severity']}, Message: {error['message']}, Source: {error['source']}")
else:
    print("No Checkstyle errors found or failed to parse the file.")
 
# Parse the PMD XML file
pmd_violations = parse_pmd(pmd_file_path)
 
# Print the parsed PMD violations to the console
if pmd_violations:
    print("\\nPMD Violations:")
    for violation in pmd_violations:
        print(f"File: {violation['file']}, Line: {violation['beginline']}, Rule: {violation['rule']}, Message: {violation['message']}, URL: {violation['externalInfoUrl']}")
else:
    print("\\nNo PMD violations found or failed to parse the file.")
 
test_results = parse_test_results(test_file_path)
 
# Define metadata
student_name = "CodeInspector"
 
# Get the current date and time
current_datetime = datetime.now()
check_date = current_datetime.strftime("%Y-%m-%d_%H-%M-%S")  # Format to avoid invalid characters in file names
 
# Generate the JSON output
output_json = create_json_output(student_name, check_date, checkstyle_errors, pmd_violations, test_results)
 
# Create the output directory if it doesn't exist
output_dir = "build/test-reports/"
os.makedirs(output_dir, exist_ok=True)
 
# Create a dynamic output file name
output_file_path = os.path.join(output_dir, f"violations.json")
 
# Save the JSON output to the file
with open(output_file_path, 'w') as json_file:
    json.dump(output_json, json_file, indent=4)
 
print(f"JSON output saved to {output_file_path}")

grade_report_dir = "build/grade-reports/"
grading_config_path = "lib/grading_config.json"
os.makedirs(grade_report_dir, exist_ok=True)

# create a dynamic grade report file name
grade_report_file_path = os.path.join(grade_report_dir, f"{check_date}.txt")

# process checkstyle violations
def process_checkstyle_violations(checkstyle_violations):
    processed_checkstyle_violations = {}
        
    for violation in checkstyle_violations:
        file = violation.get("file") # get the filepath of the file where the error was detected
        
        # split the string to get the second do last part, i.e the error catrgory
        category = violation.get("source").rsplit(".", 2)[-2]
        # split the string to get the last part, i.e the error type
        type = violation.get("source").rsplit(".", 1)[-1] 
        severity = violation.get("severity")
         
        # this next block simply aims to increase the counter of the found error type, which is stored 
        # inside a three-times nested dictionary.
        
        # make sure the file exists in the dictionary and set up the desired severity order
        if file not in processed_checkstyle_violations:
            processed_checkstyle_violations[file] = {
                "info": {},
                "warning": {},
                "error": {}
            }

        # make sure the category exists in the severity dictionary
        if category not in processed_checkstyle_violations[file][severity]:
            processed_checkstyle_violations[file][severity][category] = {}

        # make sure the error type counter or initialize it with 1
        if type in processed_checkstyle_violations[file][severity][category]:
            processed_checkstyle_violations[file][severity][category][type] += 1
        else:
            processed_checkstyle_violations[file][severity][category][type] = 1
    return processed_checkstyle_violations
            
# process pmd violations            
def process_pmd_violations(pmd_violations):
    processed_pmd_violations = {}        
            
    for violation in pmd_violations:
        file = violation.get("file")
        
        category = violation.get("ruleset")
        type = violation.get("rule")
        priority = violation.get("priority")
        
        # this next block simply aims to increase the counter of the found error type, which is stored 
        # inside a three-times nested dictionary.
        
        # make sure the file exists in the dictionary and set up the desired priority order
        if file not in processed_pmd_violations:
           processed_pmd_violations[file] = {
               "5": {},
               "4": {},
               "3": {},
               "2": {},
               "1": {}
           }
        
        # make sure the category exists in the priority level dictionary  
        if category not in processed_pmd_violations[file][priority]:
            processed_pmd_violations[file][priority][category] = {}
        
        # increment the error type counter or initialize it with 1
        if type in processed_pmd_violations[file][priority][category]:
            processed_pmd_violations[file][priority][category][type] += 1
        else:
            processed_pmd_violations[file][priority][category][type] = 1       
    return processed_pmd_violations     

def get_failed_tests(unit_testing_report):
# extract list of failed test cases from the test results
    unit_tests = unit_testing_report.get("testCases", [])
    failed_tests = []
            
    for unit_test in unit_tests:
        if unit_test.get("status") == "FAILED":
            failed_tests.append(unit_test) 
    return failed_tests     

def update_violation_breakdown(breakdown_dict, totals_dict, level_key, nested_dict):
    # initialize totals
    totals_dict[level_key] = totals_dict.get(level_key, 0)

    # initialize category/type structure if not yet present
    if level_key not in breakdown_dict:
        breakdown_dict[level_key] = {"categories": {}, "types": {}}

    for category, type_dict in nested_dict.items():
        # initialize category totals
        categories_of_level = breakdown_dict[level_key]["categories"]
        categories_of_level[category] = categories_of_level.get(category, 0)

        # initialize type breakdown for category
        types_of_level = breakdown_dict[level_key]["types"]
        if category not in types_of_level:
            types_of_level[category] = {}

        for error_type, count in type_dict.items():
            # update totals
            totals_dict[level_key] += count
            categories_of_level[category] += count
            types_of_level[category][error_type] = types_of_level[category].get(error_type, 0) + count

def generate_checkStyle_output(number_of_checkstyle_violations, checkstyle_dict, lines_of_code):
# generate a summary string for CheckStyle violations including totals and most common issues
    severity_totals = {}
    severity_breakdown = {}

    # iterate over each file and its associated severity dictionary from the CheckStyle violation data
    for file, severity_dict in checkstyle_dict.items():
        # for each severity level and its corresponding category dictionary
        for severity, category_dict in severity_dict.items():
            update_violation_breakdown(severity_breakdown, severity_totals, severity, category_dict)

    checkstyle_lines = [
        f"\nCHECKSTYLE {'-' * 45}\n",
        f"\nAn overall of {number_of_checkstyle_violations} errors were detected by CheckStyle.",
        f"\n\nBreakdown by severity level:\n"
    ]
    
    total_penalty = 0
    total_weighted_error_density = 0
    
    for severity, count in severity_totals.items():
        checkstyle_lines.append(f"\n Severity: {severity} - {count} violations\n")

        # Most common category
        category_counts = severity_breakdown[severity]["categories"]
        most_common_category = max(category_counts.items(), key=lambda x: x[1], default=("None", 0))
        checkstyle_lines.append(f"  Most frequent category: {most_common_category[0]} "
                                f"({most_common_category[1]} occurrences)\n")

        # Most common type
        type_counts_flat = {
            typeName: count
            for category in severity_breakdown[severity]["types"].values()
            for typeName, count in category.items()
        }
        most_common_type = max(type_counts_flat.items(), key=lambda x: x[1], default=("None", 0))
        checkstyle_lines.append(f"  Most frequent type: {most_common_type[0]} "
                                f"({most_common_type[1]} occurrences)\n")
        
        adjusted_penalty, weighted_error_denstiy = get_adjusted_penalty(severity, count, lines_of_code, "checkstyle")
        total_penalty += adjusted_penalty
        total_weighted_error_density += weighted_error_denstiy
    
    with open(grading_config_path, "r") as file:
        data = json.load(file)
        coding_std_range = data.get("criteria_ratings", {}).get("coding_standards", {})
        max_score = coding_std_range.get("excellent", 0)
        min_score = coding_std_range.get("unsatisfactory", 0)
        
    final_pen = min(total_penalty, max_score)
    final_score = max(max_score - final_pen, min_score)

    return checkstyle_lines, final_score, total_weighted_error_density

def generate_pmd_output(number_of_pmd_violations, pmd_dict, lines_of_code):
    # Generate a summary string for PMD violations including totals and most common issues
    priority_totals = {}
    priority_breakdown = {}

    # iterate over each file and its associated priority dictionary from the PMD violation data
    for file, priority_dict in pmd_dict.items():
        # for each priority level and its corresponding category dictionary
        for priority, category_dict in priority_dict.items():
            update_violation_breakdown(priority_breakdown, priority_totals, priority, category_dict)

    pmd_lines = [
        f"\nPMD {'-' * 50}\n",
        f"\nAn overall of {number_of_pmd_violations} errors were detected by PMD.",
        f"\n\nBreakdown by priority level:\n"
    ]

    total_penalty = 0
    total_weighted_error_density = 0

    for priority, count in sorted(priority_totals.items(), key=lambda x: int(x[0])):
        pmd_lines.append(f"\n Priority {priority} - {count} violations\n")

        # Most common category
        category_counts = priority_breakdown[priority]["categories"]
        most_common_category = max(category_counts.items(), key=lambda x: x[1], default=("None", 0))
        pmd_lines.append(f"  Most frequent category: {most_common_category[0]} "
                         f"({most_common_category[1]} occurrences)\n")

        # Most common type
        type_counts_flat = {
            typeName: count
            for category in priority_breakdown[priority]["types"].values()
            for typeName, count in category.items()
        }
        most_common_type = max(type_counts_flat.items(), key=lambda x: x[1], default=("None", 0))
        pmd_lines.append(f"  Most frequent type: {most_common_type[0]} "
                         f"({most_common_type[1]} occurrences)\n")
        adjusted_penalty, weighted_error_density = get_adjusted_penalty(priority, count, lines_of_code, "pmd")
        total_penalty += adjusted_penalty
        total_weighted_error_density += weighted_error_density
    
    with open(grading_config_path, "r") as file:
        data = json.load(file)
        coding_std_range = data.get("criteria_ratings", {}).get("coding_standards", {})
        max_score = coding_std_range.get("excellent", 0)
        min_score = coding_std_range.get("unsatisfactory", 0)
        
    final_pen = min(total_penalty, max_score)
    final_score = max(max_score - final_pen, min_score)

    return pmd_lines, final_score, total_weighted_error_density

def get_adjusted_penalty(violation_level, count, lines_of_code, tool_name):
    # try:
    with open (grading_config_path, "r") as file:
        data = json.load(file)
        weights = data.get("weights", {}).get(tool_name, {})
    
    adjusted_pen, absolute_pen = 0, 0
    print(weights)
    if violation_level in weights:
        absolute_pen = weights[violation_level] * count
        print(f"absolute_pen for {tool_name}, {violation_level}: {absolute_pen}\n"
                f"abs_pen = {weights[violation_level]} * {count}\n")
    else:
        print(f"Error calculating penalty for {tool_name}, {violation_level}")
        return 0
    
    if lines_of_code == 0:
        return 0
    
    weighted_error_density = absolute_pen / lines_of_code
    error_density = count / lines_of_code
    adjusted_pen = absolute_pen * error_density
            
    # except Exception as e:
    #     print(f"Error while opening weights JSON file. ERROR: {e}")
    #     return 0
    
    return adjusted_pen, weighted_error_density     
 
def generate_unitTesting_output(unit_test_failures, number_of_tests, number_of_failures):
# Generate a formatted output of failed unit test cases with descriptions
    unit_testing_lines = [
            f"\n\n{'=' * 30}   REQUIREMENTS + RUNTIME   {'=' * 40}\n",
            f"\nJUNIT {'-' * 45}\n\n",
            f"An overall of {number_of_failures} out of {number_of_tests} unit tests failed.\n",
            f"\nThe following are the ones that failed:\n"
        ]
                
    for test_fail in unit_test_failures:
        test_name = test_fail.get("name")
        error_message = test_fail.get("failureDetails").get("message")
        unit_testing_lines.append(f"    Test: {test_name} failed with the error: {error_message}\n")
        
    return unit_testing_lines 
   
def generate_score_output(requirements_score, runtime_score, coding_stand_score):
    # Compute final score with the individual rubric scores
    student_score_output = [
            f"\n{'=' * 35}  FINAL SCORE   {'=' * 45}",
            f"\n    - Requirements: {requirements_score}",
            f"\n    - Coding Standards: {coding_stand_score}",
            f"\n    - Runtime: {runtime_score}",
            f"\n    - Efficieny: TBD",
            f"\n{'=' * 100}",
            f"\n    - Overall: {requirements_score + runtime_score + coding_stand_score}",
            f"\n{'=' * 45} END REPORT {'=' * 45}"
        ]
    return student_score_output

def get_run_and_req_score(number_of_tests, number_of_failures):
# Calculate the requirement and runtime score based on passed unit tests
    requirements_score_range = [60, 48, 36, 10, 0]
    runtime_score_range = [20, 16, 12, 8, 0]
    
    if number_of_tests == 0:
        print("Number of Junit tests is 0.")
        return 0, 0
    
    unit_test_success_ratio = 1 - round((number_of_failures / number_of_tests), 1)
    requirements_score = 0
    runtime_score = 0
    
    if unit_test_success_ratio >= 0.9:
        requirements_score = requirements_score_range[0]
        runtime_score = runtime_score_range[0]
    elif unit_test_success_ratio >= 0.8:
        requirements_score = requirements_score_range[1]
        runtime_score = runtime_score_range[1]
    elif unit_test_success_ratio >= 0.5:
        requirements_score = requirements_score_range[2]
        runtime_score = runtime_score_range[2]
    elif unit_test_success_ratio > 0:
        requirements_score = requirements_score_range[3]
        runtime_score = runtime_score_range[3]
    else:
        requirements_score = requirements_score_range[4]
        runtime_score = runtime_score_range[4]
    return requirements_score,runtime_score

def calculate_percentile_score(checkStyle_error_density ,pmd_error_density, total_error_density):
    data = pd.read_csv("lib/weighted_data.csv", header=0)
    checkstyle_data = data["cs_density"].to_numpy()
    pmd_data = data["pmd_density"].to_numpy()
    total_data = data["total_density"].to_numpy()
    
    percentile_checkstyle = round(percentileofscore(checkstyle_data, checkStyle_error_density, kind="rank"))
    percentile_pmd = round(percentileofscore(pmd_data, pmd_error_density, kind="rank"))
    percentile_overall = round(percentileofscore(total_data, total_error_density, kind='rank'))
    
    return percentile_checkstyle, percentile_pmd, percentile_overall

# generate grade report using the previously constructed JSON file
def create_grade_report(json_output_file_path):
# Main function: parse JSON report, process violations and test results, generate formatted output, and save to file
    # try:
    with open(json_output_file_path, "r") as file: # open violations JSON file in read-mode
        data = json.load(file)

    # store and split up the extracted data
    student_name = data.get("studentName")
    report_date = data.get("checkDate")
    violations = data.get("violations", {})
    lines_of_code = data.get("linesOfCode")
    
    # extract different violation lists 
    checkstyle_violations = violations.get("checkstyle", []) 
    pmd_violations = violations.get("pmd", []) 
    unit_testing_report = violations.get("Unit testing", {})
    
    number_of_checkstyle_violations = len(checkstyle_violations)
    number_of_pmd_violations = len(pmd_violations)
    
    # process checkstyle and pmd violations
    checkstyle_dict = process_checkstyle_violations(checkstyle_violations)
    pmd_dict = process_pmd_violations(pmd_violations)
    
    # get unit testing details
    unit_test_failures = get_failed_tests(unit_testing_report)
    number_of_tests = int(unit_testing_report.get("summary").get("testsRun"))
    number_of_failures = int(unit_testing_report.get("summary").get("failures"))
    
    # intro lines for report
    intro_lines = [
        f"This is report {report_date} for student {student_name}\n",
        f"\nThe report covers a total of {lines_of_code} lines of code\n",
        f"\n{number_of_checkstyle_violations} errors were detected by CheckStyle",
        f"\n{number_of_pmd_violations} errors were detected by PMD",
        f"\n{number_of_failures} out of {number_of_tests} unit tests failed.",
        f"\n\nReport: \n",
        f"\n{'=' * 25}   CODING STANDARDS   {'=' * 50}\n"
    ]
    
    # generate summary output lines
    checkStyle_lines, checkStyle_score, checkstyle_weighted_density = generate_checkStyle_output(
        number_of_checkstyle_violations, 
        checkstyle_dict,
        lines_of_code
    )
    
    pmd_lines, pmd_score, pmd_weighted_density = generate_pmd_output(
        number_of_pmd_violations, 
        pmd_dict,
        lines_of_code
    )
    
    total_weighted_density = checkstyle_weighted_density + pmd_weighted_density
    checkstyle_percentile, pmd_percentile, overall_percentile = calculate_percentile_score(
        checkstyle_weighted_density,
        pmd_weighted_density,
        total_weighted_density
    )
            
    checkStyle_lines.append(
        f"\n\nOverall weighted CheckStyle error density: {round(checkstyle_weighted_density, 5)}"
        f"\nThis places you in the {checkstyle_percentile}th percentile of submissions in the database."
        f"\nThat is, {100 - checkstyle_percentile}% of submissions had a higher CheckStyle error density than yours.\n"
    )
    
    pmd_lines.append(
        f"\n\nOverall weighted PMD error density: {round(pmd_weighted_density, 5)}"
        f"\nThis places you in the {pmd_percentile}th percentile of submissions in the database."
        f"\nThat is, {100 - pmd_percentile}% of submissions had a higher PMD error density than yours. "
    )
    
    coding_style_summary_lines = [
        f"\n\nSUMMARY  {'-' * 40}\n",
        f"\nThe cumulative weighted error density of you submission is: {round(total_weighted_density, 5)}.",
        f"\nThis places you in the: {overall_percentile}th percentile.",
        f"\nThat is, {100 - overall_percentile}% of the average student submission have a higher error density than yours."
    ]
    
    unit_testing_lines = generate_unitTesting_output(
        unit_test_failures, number_of_tests, 
        number_of_failures
    )

    print(f"CheckStyle Score: {checkStyle_score}\n"
            f"PMD score: {pmd_score}\n")
    
    # generate student score output
    requirements_score, runtime_score = get_run_and_req_score(number_of_tests, number_of_failures)
    coding_std_score = round((checkStyle_score + pmd_score) / 2)
    score_lines = generate_score_output(requirements_score, runtime_score, coding_std_score)
    
    with open(grade_report_file_path, "w") as file:
        file.writelines(intro_lines)
        file.writelines(checkStyle_lines)
        file.writelines(pmd_lines)
        file.writelines(coding_style_summary_lines)
        file.writelines(unit_testing_lines)
        file.writelines(score_lines)
    
    print(f"Grade report created and saved to: {grade_report_file_path}")
        
    # except Exception as e:
    #     print(f"Failed to generate report: {e}")
    #     return []
    
create_grade_report(output_file_path)