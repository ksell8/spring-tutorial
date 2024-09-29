# Application Interfaces

An application, or app, is a self-contained computer program that provides
some functionality.  This functionality is provided to a consumer via **consumer interfaces**.  
Consumer interfaces should be familiar to anyone who uses technology.  A video game controller and everything you can do with it is a consumer
interface.  A website is a consumer interface.  The GUI of your computer desktop is a consumer interface.
Whenever we are designing consumer interfaces we want to make sure they *simple and easy to learn*, without compromising on *functionality*.

To not mix words, we will say all applications must have a consumer interface.  Anything that does not serve an application to a consumer,
but provides some functionality towards creating a larger application we will call a **service**.  Apps rely on lots of
smaller pieces working together in the background. Imagine a car: while the driver only sees the steering wheel and pedals (consumer interface),
under the hood, there are hundreds of different parts working together.

!!! info "Terminology"
    Services are applications themselves.  As they are self-contained computer programs that provide some functionality. But we will specifically refer to non-consumer apps as services.  As one app can provide multiple services, it can get confusing
    when you start to talk about applications within applications, if you don't distinguish the inner applications (services) from the parent application.
    
    In summary, **applications** are often made up of **services** and have **consumer interfaces**.


If an app tries to handle everything by itself (all the code and functionality in one place), it becomes too large and difficult to manage. 
We call this **tight coupling**, and it's like using string lights with an open circuit—if one light goes out, they all go out.  By breaking
the application into separate services (adding shunts so not all the lights are connected), we can notice when the one service fails (the light goes out) and recover
the failing service (replace the dead bulb) while the rest of the application remains in operation.  This is called **fault tolerance**.  

!!! example "Example: Netflix"

    Netflix's application provides a lot of different services to its users—like showing you a list of recommended movies, streaming shows, handling user accounts, etc. 
    To make sure everything runs smoothly, they break up these services into smaller, independent parts called microservices.
    Microservices are responsible for a specific task, and they work independently, but together they make the whole Netflix app function.
    
    Here's how Netflix uses microservices:
    
    User Service: When you log into Netflix, a microservice specifically handles your login and manages your account information.
    
    Recommendation Service: After you log in, Netflix shows you a list of recommended movies and shows based on what you've watched before. There’s a microservice dedicated just to analyzing your viewing habits and recommending new things.
    
    Streaming Service: When you press play on a movie or show, a special microservice handles the video streaming. It makes sure the video loads smoothly at the best quality for your internet speed.
    
    Search Service: When you type in a movie or actor's name, a search microservice finds the shows or movies you're looking for.
    
    Billing Service: This microservice deals with payments and subscriptions. It makes sure Netflix charges you correctly every month and handles any payment issues.

Services are cool, but from a consumer viewpoint I don't see multiple services.  I only see the whole application.  So how does
the consumer interface use the services without me knowing it?  Also, what if one service needs to talk to another service?

Each service provides an **API** or **Application Programming Interface** (remember a service is itself an application)
that tells other software components how to talk to it.  The consumer interface under the hood makes a number of API
calls to each of its component services in order to serve the application to the consumer.

There are lots of different ways to give a software application to a user.  Here are just a few examples.

1. Load the software onto a device (like a video game console or robot vacuum) and send the device to a consumer.
2. Provide the application in a mobile app store. 
3. Provide the application to install as a binary on a desktop.
4. Provide the application as a web application.

!!! note
    1, 2, and 3 can all be instances of 4.  4 in it's simplest manifestation is a website in a browser like
    Chrome, Arc, or Safari.  But an instance of 1, 2, and 3 that requires a connection to the internet is
    using some form of 4.  For this reason, communication between applications over the internet is 
    critically important and the subject of Web APIs is huge!  We will cover only a small part of the landscape.

# Web APIs

Web traffic occurs between **clients** and **servers**.  The customer is a client that requests data from a server
which serves the application on the client's web browser, mobile application, or desktop application.
The server provides public APIs to the client, and it has private APIs that only it can call.  The public APIs
can support authentication methods which only allow certain calls depending on the user.  For example,
I can delete my own posts on social media, but I can't delete other users' posts.

!!! info "Terminology"
    In web development the consumer interface is often called the **frontend**, while the hidden components that the
    consumer doesn't know exists are called the **backend**.  It is for this reason, that backend developers often
    maintain APIs, while frontend developers control the code that renders the application based on the information
    returned from the APIs.

    This tutorial and associated lesson sets you up for *backend* Java development as Spring is a *backend* Java framework.

Web APIs can trigger many different types of events, but the one's we are primarily concerned with are:
create, read, update and delete.  These actions are so well used across all applications that there
is an acronym for them, CRUD!

There are many different ways to provide CRUD interfaces to users but we'll be covering the two most popular
to implement with the Java Spring Framework.

Both of the APIs we will be using have well defined specifications.  It is best to write these specifications first
as it can help with code and documentation generation and to validate existing implementations of interfaces against new
schema changes.  This approach to API development is called *schema first*.

### REST APIs

REST stands for Representational State Transfer.  The state we are transferring is the CRUD operation we want to perform
on the data the application we are querying stores.

!!! info "Terminology"
    **State** is a snapshot of data.  To change state is to change the data.

    REST itself is **stateless**.  It transfers a requested state change, but it only knows about the state it is asking about.
    It contains no record of previous API calls.  You can store this state on the server or client, but REST doesn't do this out of the box.

REST APIs specify different paths, which which called with different [HTTP Methods](networking.md) make state changes or
query for current state.  The specification for REST is called [Open Api Specification](https://swagger.io/specification/v2/).
Each path is defined with the http methods it defines nested underneath where the arguments and responses are defined.

### GraphQL APIs

GraphQL differs from REST in that it only uses one path `/graphql` and two methods (POST, GET).  Each API call to
the GraphQL endpoint defines the specific type of state change it wants to perform in the body of the API call.
These types of state changes are called queries and mutations and we will go over them in-depth later where we will
also learn about the GraphQL schema language.

!!! info "Terminology"
    Why is GraphQL called GraphQL?  GraphQL stands for Graph Query Language. In this context, "graph" refers to how 
    data is connected. Imagine a graph as a web or a network of related information. For example, think of a social network 
    like Instagram: a user is connected to their posts, their followers, and the comments on those posts. 
    These connections between pieces of data form a graph. In GraphQL, you can follow these connections, like tracing a path 
    through a web, to get the exact data you want.

Interested on learning more about GraphQL NOW, skip ahead to [the GraphQL section](../graphql/schema.md)!

Now we know popular ways to set up our web APIs.  We need figure out how exactly the data will be sent from one 
machine to another.  To do so we will need to understand basic networking.