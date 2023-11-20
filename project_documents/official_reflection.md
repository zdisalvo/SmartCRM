# zdisalvo Project Reflection



*Please answer at least one question from each section below. Answers here will
likely be inspiration for the “lessons learned” section of your project
presentation at the end of the unit.*

## Design

* How closely did you follow your design document after the review was complete?
  Did your implementation need to change based on what you learned once you were
  underway?

#### I adhered closely to the design of the Client class, using most of the same attributes. I added the log note feature that I intended, I added the general notes feature, and I was also able to implement sending an email directly to the client from the client page. After I completed the client portion of the project, I decided to hold off on creating the User and Manager classes to maintain simplicity. If I were to include those I would have had to add a system for Client ownership which would have involved adding a user Id attribute to the client, then having a fluid log in system for each user. The time involved in doing that seemed to be a risk in voiding an already working interface.

## Project

* How did you handle the ambiguity of defining your own project and user
  stories? What strategies did you use to decide on concrete work to do to
  satisfy your requirements?

#### My project tackled a fairly well known problem of client relationship management. I used some of the knowledge of working with various CRM's through my sales career to take the features of what worked and simplify. Once I had an idea of what I wanted, I developed the back end interface for the Create Client endpoint, then started developing the front end to ensure that it all would tie together properly. After I was able to get the front end to work, I rolled out the rest of the end points, Get Client, Update Client, and Add Log Note. From there it was a lot of googling and trial and error to get JavaScript to translate the incoming JSON data to a fluid web interface.

* How did you deal with getting stuck on a problem? What strategies did you
  employ to get yourself unblocked?

#### I tried various combinations of code. I used code example forums. Sometimes I had to go about solving a problem a completely different way then what I had been attempting for hours. At one point I did involve my learner assistant when I was having trouble sending a JSON request from Ajax.

* Did any of your commitments you made in your team charter help navigate a
  difficult decision, situation, or collaboration challenge? How?

#### I did not work as a team, however I did over-commit myself to several very difficult features which I was unclear on how they could be implemented. If I was working as a team I think some collaboration would have been helpful on how to work through the problem. I used determination and grit to find the answers I sought and was able to get most of what I wanted to work as intended. 

## Scrum

* What did you find to be the most valuable part of daily stand-ups? Is there
  anything you would want to do differently at stand-up to make it more useful
  to you?

#### I did not utilize this because I did not work with a team. Had I done stand ups, I would have gone through what I had accomplished. What I was having trouble with, and giving suggestions of how to solve the problem I was stuck on. I would also have worked with the team on goals for the day or that week to ensure we were on track to completion.

* Did you over or underestimate the work you could complete during your sprints?
  What have you learned that will help you better estimate work next time?

#### I think I slightly overestimated how long things would take. Specifically, my lack of knowledge of JSON processing requests and Java Script held me back significantly. Then, I had to fully learn how to present data on a webpage without having any knowledge going in.

## Looking ahead

* If you were to start this unit over again, what would you do differently? How
  do you see yourself applying that to your work in later units, the capstone,
  or your internship?

#### I don't think I would have done much of anything differently. I took some time marinating over the Design Document at first to really think about what I wanted. It took me about two weeks to get there. Then I spent about a week to code out the project, which was about half the features I wanted. My main goal though was to get the CRM working which I did. It would have been nice to add the User feature and assign and get leads but I think the time involved would have been 2-3 more weeks. In order to build a fully functional CRM, it would take months of working with a team to get everything working correctly. One thing I would say that has worked for me when I'm stuck on something is to just get started. Once I am working on a problem I will do everything I can to figure out the solution.
