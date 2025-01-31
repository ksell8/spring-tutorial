# Learn Computer Science 

## Aims

This guide aims to teach basic computer science concepts while connecting
them to modern day computing frameworks and their historical predecessors.
It aims to teach theoretical computing through practical
computing disciplines.  Allowing the student to learn not only how
to build industry standard applications, but *why* things work the way they do.

We will learn about computing languages and translation, operating systems, networking, and interfaces.
We will use these theoretical concepts to dissect real world implementations of these
ideas including: Java, Spring, GraphQL, Docker, MongoDB and Maven.

These topics will cumulate in a project tutorial which will allow the student
to implement their knowledge by building a backend API for a web application.

## How is the Guide Formatted?

This guide is broken into 2 main sections: Learn and Tutorial.

It is strongly suggested that the student go through the Learn section in its totality
before navigating through the tutorial.

However, the Tutorial section will reference the Learn section to justify decisions made and provide opportunities for 
exploring touched on topics in-depth, should you decide to skip ahead.  Just to reiterate, it is *strongly*
suggested to not skip the Learn section unless you already have a deep background in computer science
and are solely interested in learning more about the stack for this project.  Churning out code is
becoming less of a relevant skill.  Understanding why pieces of a system are needed and how they integrate
together will always be critical.

## What *is* the Tutorial Project?

The tutorial project is a GraphQL API for tracking books in a personal
library.  If you aren't interested in that project, the book tracking concept can be modified in place to
track a number of items that may be of more interest: recipes,
groceries, tasks, shoes, collectables, exercise log, or movies, just to name a few. I
decided to focus on books, because I have quite a big
library and a need to track them.  Build what *you* will use!

Future work includes a tutorial which will use Spring-Security
to secure an API for a Battleship game.  Stay tuned for more!

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

### Why learn to write tests?

If you are writing code you should be writing tests.  If you don't find bugs
in the development process, your users will.  We'll learn about the junit testing framework
as well as helpful testing libraries like testcontainers and toxiproxy.


