# Learn Java Spring

## Aims

This guide aims to teach basic computer science concepts while learning
how to build and host a Java Spring-Boot Application.
It aims to teach theoretical computing through practical
computing disciplines.  Allowing the student to learn not only how
to build industry standard applications, but why things work the way they do.

The tutorial that will teach how to build a Java GraphQL API
connected to a MongoDB database.  We will learn about systems
such as the Spring Framework, Tomcat, Docker, Maven, Gradle, Git, Java and JUnit.
Which will teach us about operating systems, computing languages, security,
systems of control, and the internet.

## Why Learn Spring?

Spring makes it easy to create enterprise level
Java backends for web applications.  It is used at companies
like Netflix, Visa, Spotify, and Atlassian.
Spring-Boot is the controller of Spring based backends. It uses 
annotations (introduced in Java 5) to create specialized items
called Spring Beans.  These Spring Beans are magic beans that 
have specialized instructions on them that tells Spring-Boot 
how to set things up so you don't have to. 

## Why Learn Docker?

Docker helps you host applications in a way that they can be lifted
and moved to any server.  The dependencies of the application
are controlled in a special file called a Dockerfile.  All you need is Docker on the machine and you can
run the container and thus host the application.

!!! note

    Multiple tools now support running containers.  Any tool
    that can run OCI-compliant images can run a container built
    and distributed with Docker.  OCI stands for Open Container
    Initiative.

Compared to container images, the other way to use pre-built machine images is with Virtual Machine
images.  Docker is more lightweight as it relies on the host machine's
operating system (on Mac and Windows Docker Desktop creates a Linux VM
which is used).  VMs include a full operating system, making it more hefty
and take longer to startup.  The big benefit of Docker is that
the images can be configured as code.  This makes it easier to reproduce
the image and to understand exactly what it includes.

We'll go over both methods of virtualization in depth later.

## How is the Guide Formatted?

This guide is broken into 2 main sections: Learn and Tutorial.
The tutorial will walk you through the steps to create a Spring based project.
The learn section will provide an in-depth overview about the tools used.

The tutorial section will reference the learn section to justify decisions
made and provide opportunities for exploring touched on topics in-depth.

It's suggested that the student walk through the tutorial project
and reference the learn section as needed.  Even if this is your first time coding the
tutorial section will give you everything you need to get started.

The tutorial project is a GraphQL API for tracking books in a personal
library.  If you aren't interested in that project, the book tracking concept can be modified in place to
track a number of items that may be of more interest: recipes, 
groceries, tasks, shoes, collectables, exercise log, or movies. I 
decided to focus on books, because I have quite a big 
library and a need to track them.  Build what you will use!

Future work includes a tutorial which will use Spring-Security
to secure an API for a Battleship game.  Stay tuned for more!

