import os
import subprocess

def commit_java_files(directory, max_commits=100):
    """
    Iterates over a directory, commits up to 10 Java files individually, and pushes each commit.
    :param directory: Path to the folder containing Java files.
    :param max_commits: Maximum number of files to commit.
    """
    java_files = [f for f in os.listdir(directory) if f.endswith(".java")]
    
    if not java_files:
        print("No Java files found in the directory.")
        return
    
    os.chdir(directory)  # Change working directory to the target folder
    
    count = 0
    for file_name in java_files:
        if count >= max_commits:
            break
        
        try:
            # Git add
            subprocess.run(["git", "add", file_name], check=True)
            
            # Git commit
            commit_message = f"Commit {file_name}"
            subprocess.run(["git", "commit", "-m", commit_message], check=True)
            
            # Git push
            subprocess.run(["git", "push"], check=True)
            
            print(f"Successfully committed and pushed {file_name}")
            count += 1
        except subprocess.CalledProcessError as e:
            print(f"Error processing {file_name}: {e}")
            break
    
if __name__ == "__main__":
    commit_java_files("src/benchmark/")
