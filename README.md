# barriott
barriott Hotel management manager

Hi Team as per the requirement i have created 3 endpoints details of them are given below
  Due to my personal issues i started developing this application yesterday.
  and due to time constraint i haven't validated the inputs and couln't able to write the Junits

1)Book a ROOM:-
-------------------------------------------
Method type:-POST

URL:- http://localhost:8080/bookRoom

BODY ex1:-
{
    "guestName": "fayaz",
    "roomNo":2,
    "bookingDate":"07-04-2023"

}


BODY ex2:-
{
    "guestName": "syed",
    "roomNo":3,
    "bookingDate":"07-04-2023"

}

2)get availableRooms:-
-------------------------------------------

Method type:-GET
URL:- http://localhost:8080/availableRooms/?requestDate=07-04-2023


3)get guestDetails with bookings:-
-------------------------------------------

Method type:-GET
http://localhost:8080/guestDetails/?guestName=fayaz
