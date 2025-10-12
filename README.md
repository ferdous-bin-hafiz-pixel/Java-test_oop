Check Java & javac
Open Command Prompt and run:

java -version javac -version

If javac shows a version , then it's okay . If javac is not recognized, continue to step 2 to add JDK bin to PATH (or install JDK first).

(If needed) Add JDK bin to PATH
Replace C:\Program Files\Java\jdk1.8.0_401 with your JDK folder if different.

CMD (persistent):

setx JAVA_HOME "C:\Program Files\Java\jdk1.8.0_401" setx PATH "%PATH%;C:\Program Files\Java\jdk1.8.0_401\bin"

Important: Close all Command Prompt windows and open a new one after running those setx commands.

Verify javac again
Open a new CMD and run:

javac -version

Expected output example:

javac 1.8.0_401

Create the Java source file Option A — using Notepad (manual paste)
Run this to open Notepad, then copy & paste the code below and save as Hello.java on Desktop:

notepad "%USERPROFILE%\Desktop\Hello.java"

Code to paste into Notepad:

public class Hello { public static void main(String[] args) { System.out.println("Hello, World!"); } }

Compile the program (copy-paste)
Open Command Prompt, go to Desktop and compile:

cd %USERPROFILE%\Desktop javac Hello.java

If no output and no .class errors → success. Hello.class should appear on Desktop.

Run the program (copy-paste) java Hello
Expected output:

Hello, World!
