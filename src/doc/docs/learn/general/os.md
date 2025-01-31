# What is a kernel?

A computer runs lots of tasks at once.  It needs some way to manage the 
computation and space resources of the processes.  This may seem like a 
simple thing to do, but quite a lot happens on a computer at once.  To
prove that to you let's run an experiment.

!!! example "Experiment: What is Running on My Computer?"
    
    === "*nix"
        Navigate to your terminal application.  Type in the command & hit enter:
        ```
            ps aux
        ```
        
        This command spits out all of the running processes on your computer.
        
        Now type:
        ```
            top # To exit top click ctrl+C.
        ```
        
        This will show you the memory and percentage of the CPU (central processing unit)
        that each of the processes are using.
    
    === "Windows"
        Navigate to your command prompt application.  Type in the command & hit enter:
        ```
            tasklist /v
        ```
        
        This command spits out all of the running processing on your computer.  It
        will also show you the memory and percentage of the CPU (central processing unit)
        that each of the processes are using.

??? question "Experiment: How Many Processes are Running On My Computer?"
    
    How many processes are running on your computer?
    
    Determine how to count from the command line from your particular operating system shell and count
    the lines from the commands from the above experiment.

    How would *you* go about organizing the processes and their resources?
    How would you allocate and reference process memory?
    How would you allow processes to start their own processess?  How would they stop them?  What if they don't stop them?
    How would you schedule processes to run computation on the CPU (central processing unit)?
    
    
