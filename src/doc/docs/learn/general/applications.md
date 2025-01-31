# What is an Application?

An application, or app, is a computer program that provides
some functionality.  This functionality is provided to a user via **user interfaces**.  
User interfaces should be familiar to anyone who uses technology.  A video game controller and everything you can do with it is a user
interface.  A website is a user interface.  All GUIs (graphical user interface) are user interfaces.
Whenever we are designing user interfaces we want to make sure they *simple and easy to use for **all** people*, without compromising on *functionality*.

There are many different types of applications:

* Web Applications
* Mobile Applications
* Desktop Applications
* Command Line Applications
* Embedded Applications (i.e. robotics, video game consoles, appliances)
* Network Applications

Embedded applications rely on running computation on a device.  
That device can interact with other devices and other types of applications.
The interconnection of devices through the internet is referred to as IoT (Internet of Things).

Desktop applications run on a computer and have a GUI.  A common Desktop application is a browser
(Chrome, Safari, Firefox) which displays the graphical content of Web applications.
Viewing the graphics of a web application is actually quite complex, and browsers make the user interface
easier to manage. Browsers are a crucial tool in developing web applications.

Command line applications run on computers without a GUI.  You use command line interfaces
(or CLIs) by going to the Terminal or Command Prompt and invoking the command.

Mobile applications run on mobile devices.  The two major types of mobile devices are
Apple and Android.  Both types have browser applications.  When developing
the graphics for a web application it is important to handle all types of viewports.

While, web applications are the focus of this tutorial, it is important to recognize
all types of applications as most applications interact with web applications in some way.

These applications interact with each other via APIs or Application Program Interfaces.

# Web APIs

Web traffic occurs between **clients** and **servers**.  The customer is a client that requests data from a server
which serves the application on the client's web browser.
The server provides public APIs to the client, and it has private APIs that only it can call.  The public APIs
can support authentication methods which only allow certain calls depending on the user.  For example,
I can delete my own posts on social media, but I can't delete other users' posts. 

Web APIs can trigger many different types of events, but the one's we are primarily concerned with when manipulating data are:
create, read, update and delete OR CRUD!

There are many different ways to provide CRUD interfaces to users but we'll be covering the two most popular
to implement with the Java Spring Framework.

Both of the APIs we will be using have well defined specifications.  It is best to write these specifications first
as it can help with code and documentation generation and to validate existing implementations of interfaces against new
schema changes.  This approach to API development is called *schema first*.

### REST APIs

REST stands for Representational State Transfer.  The state we are transferring is the CRUD operation we want to perform
on the data of the application we are querying.

!!! info "Terminology"
    **State** is a snapshot of data.  To change state is to change the data.

    REST itself is **stateless**.  It transfers a requested state change, but it only knows about the state it is asking about.
    It contains no record of previous API calls.  You can store this state on the server or client, but REST doesn't do this out of the box.

REST APIs specify different paths, which called with different [HTTP Methods](networking.md) make state changes or
query for current state.  The specification for REST is called [Open Api Specification](https://swagger.io/specification/v2/).
Each path is defined with the http methods it defines nested underneath where the arguments and responses are defined.

### GraphQL APIs

GraphQL differs from REST in that it only uses one path `/graphql` and two methods (POST, GET).  Each API call to
the GraphQL endpoint defines the specific type of state change it wants to perform in the body of the API call.
These types of state changes are called queries (GET) and mutations (POST) and we will go over them in-depth later when we
learn about the GraphQL schema language.

!!! info "Terminology"
    Why is GraphQL called GraphQL?  GraphQL stands for Graph Query Language. In this context, "graph" refers to how 
    data is connected. Imagine a graph as a web or a network of related information. For example, think of a social network 
    like TikTok: a user is connected to their posts, their followers, and the comments on those posts. 
    These connections between pieces of data form a graph, which can be queried.

Interested on learning more about GraphQL NOW, skip ahead to [the GraphQL section](../graphql/schema.md)!

Now we know popular ways to set up our web APIs.  We need figure out how exactly the data will be sent from one 
machine to another.  To do so we will need to understand basic networking.

## Bigger Picture

There are many different types of APIs.  Each type has a different way of communicating with it.
Both GraphQL and REST APIs operate over the HTTP protocol.  But APIs use a variety of protocols.
The database we will use (MongoDB) [MongoDB Wire Protocol](https://www.mongodb.com/docs/manual/reference/mongodb-wire-protocol/), 
we will use a Spring library which provides an API into the database to comm.