# Copyright Law

The United State Copyright Act provides that authors of original expression shall enjoy
the exclusive right to:
1. Copy their work
2. Distribute copies to the public
3. Prepare "derivative works" based upon their work
4. Publicly display their work

This applies to all work that is written and considered original.  A work is considered
original if it exhibits at least a modicum of creativity.  

Code is written down.  So legally it is bound by copyright.  However, code builds
on top of each other.  We are going to use MongoDB and Spring, which is based on code,
to build a derivative work which is our application.  So how can we do this, if it's under
copyright.

Copyright owners have the option to extend privileges to other parties via licenses.
It's important that you understand the licenses for all software in your proposed
stack *before* building applications on top of them.

# Open Source

**Open Source (abbreviated OS, but not the same as operating system) 
is free, but that does not mean it does not cost money if you plan to make money!**

To be considered OS your software must be *free* to redistribute. 

!!! Quote "Legalese - Free to Redistribute"

    The license shall not restrict any party from selling or giving away the software as 
    a component of an aggregate software distribution containing programs from several 
    different sources. The license shall not require a royalty or other fee for such sale.

Which means, an open source license must allow anyone to distribute the software and possibly
collect money for doing so.

Lots of software is OS, so why can't I go take it and sell it to someone?  Well, the software
is already freely available, so why would anyone buy it from me?  When they can get it for free.

But to understand why OS can *cost* you money if you aim to *make* money we must understand how
the code can be used to create derivative works.

!!! Quote "Legalese - Derivative Works"

    The license must allow modifications and derived works, and must allow them to be distributed
    under the same terms as the license of the original software.

This means that if you build on top of open source software, the license will at least allow you to
distribute your new project with the same license that it was created with.  Now, some open source licenses
like the GPL (GNU Public License) prevent you from selling the code.  So, if you use a GPL project, you wouldn't
be able to sell your new project for profit.  Most code that is licensed with the GPL is dual licensed with
a license that you can pay for and use for profit.  It is important that you understand licensing restrictions
for this reason before settling on a stack for your next venture in tech.

!!! info "Terminology"

    **Copyleft** refers to a type of license that when used requires you to license dervivate works
    under the same license type.  License that are subject to copyleft or place other restrictions
    on distribution of derivative works are often called *restrictive* licenses, while licenses that 
    allow you to distribute derivative works how you see fit are called *permissive* licenses.

These are, in my opinion, the most important parts of the definiton of OS as it pertains to licensing,
but you can find the [full OS definition on the OSI website](https://opensource.org/osd).

# Licensing

!!! example "Example - MongoDB"

    Server Side Public License (SSPL)

!!! example "Example - Spring Framework"

    Apache
