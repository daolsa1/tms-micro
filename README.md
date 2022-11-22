# TMS Microservice
This microservice has 4 different endpoints:
- startSession -> a new session is created. It returns a session identifier (sessionId).
- endSession -> it deactivates a session given a sessionId.
- addEvent -> it registers events in a batch mode given a sessionId.
- getEvents -> returns the events of a given sessionId.
