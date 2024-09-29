# Protocols

In the case of human affairs protocols are defined as "a system of rules that explain the correct 
conduct and procedures to be followed in formal situations."  For example, lawyers
have a protocol for how the can object in court.  They have to go to school to learn
how to use this protocol and if they don't follow the protocol there on consequences,
for example, they could be found in contempt of court.  

For computers, a **protocol** defines the format and the order of messages exchanged 
between two or more communicating entities, as well as the actions taken on the transmission
and/or receipt of a message or other event.  A protocol ensures computers are all speaking
the same language when communicating even if their internal languages (operating systems
and instruction sets) are vastly different.

# Protocol Layers

![OSI Model](../../resources/osi-model.gif){ align=right width=300px }

In the 1970s protocols weren't like they were today.  Each machine had its own protocol,
and thus could only talk to machines of the same model.  This kicked off a period of time
known as [the protocol wars](https://www.computerhistory.org/revolution/networking/19/376). 
By the end of the 1970s it became apparent that we would need interoperable protocols between machine types.
The International Organization for Standardization (ISO) worked for many years on creating
an international standard to unify networking under a common framework.  In 1984 they proposed
the Open Systems Interconnection (OSI) model.

The network designers wanted to create ways that these protocols could build on each other, so
they created a design which organized the protocols in layers.  Each protocol belongs to a layer and the layers
operate in a service model where it can build on the services provided by that layer
beneath it.  Users of the internet operate at the application layer, so a sender of data
sends data down from the application layer and a receiver receives the data at the lowest layer
until it moves it's way up to the application layer where the receiver can view it.  Let's 
explore this with an example.

!!! example "Example: Sending a File"
    <ol reversed>
    <li>Application Layer (Sender): You decide to send a file using an email application.</li>
    <li>Presentation Layer: The file might be compressed or encoded so that it can be transferred efficiently and to all machine types.</li>
    <li>Session Layer: A connection is established between your computer and the recipient’s computer.</li>
    <li>Transport Layer: The file is broken into smaller packets and given labels to ensure it can be reassembled in the correct order later.</li>
    <li>Network Layer: The packets are given the correct IP address of the destination computer.</li>
    <li>Data Link Layer: The packets are prepared for transfer across the physical network.</li>
    <li>Physical Layer: The data is sent as signals over the network (e.g., electrical signals over Ethernet or wireless signals over Wi-Fi).</li>
    </ol>
    Now, on the receiver's side, it goes back up the layers:
    
    1. Physical Layer: The computer receives the signals.
    2. Data Link Layer: It checks for any errors and passes the data up.
    3. Network Layer: The packets are checked to see if they are meant for this computer based on the IP address.
    4. Transport Layer: The packets are reassembled in the correct order.
    5. Session Layer: The session is managed to ensure all packets are received.
    6. Presentation Layer: The file is decompressed or decoded.
    7. Application Layer: The email client presents the file to the user.

# Server and Client vs P2P

!!! info "Terminology"

    In the early days of computers, large central computers, often called mainframes, provided computing resources to multiple users. 
    These large systems were called **hosts** because they hosted services, programs, or resources that users could access remotely, usually through terminals.
    The terminals themselves were not centrally connected, only the mainframes were connected in a network.
    
    With the invention of the internet (TCP/IP) which connected multiple independent networks together, it became
    possible for machines to connect to resources without the need for a mainframe.

    Therefore, nowadays *all machines* connected to the internet are called **hosts**.

Protocols at the application layer and the processes that use them are called network
applications.  There are two dominant architectures for network communications between 
hosts: server-and-client architecture and P2P architecture.  

In server and client architectures there are two types of hosts in a network: 1) **servers**
which respond to requests by *serving* data 2) **clients** which make requests for data.

In P2P architectures there are no special hosts which act as servers, each machine in the network can
be a server or a client at any time.

# The Internet & TCP/IP

The internet was born in 1983 when the major networks of the time switched to TCP/IP
protocols to connect them into one giant network.  The IP or internet protocol operates
at layer 3, or the network layer.  It assigns a unique address to each machine on the
internet called an IP address.  TCP, or the Transmission Control Protocol,
is a transport layer protocol which dictates the way that information should be
chunked in order to be transferred across the internet.

# The World Wide Web & Hypertext Transfer Protocol

In 1989 the World Wide Web was invented.  The web is a network application
which allows for data to be transferred between hosts in a

## Secure HTTP

# Sockets


# What is localhost?

We are building a web application.  A web application is based on the world wide web
network application, and thus needs to be served on a host.  Luckily, any machine can be a host 
so we will use *your computer* to test the web application.  

Your own computer is referred to as a local host, where other machines you connect to are
remote to your computer and called remote hosts.





### References

Much of this was adapted from the first and second chapters of Computer Networking: A Top
Down Approach by Kurose and Ross. Online Lectures from this book can be found
[here](https://gaia.cs.umass.edu/kurose_ross/online_lectures.htm).