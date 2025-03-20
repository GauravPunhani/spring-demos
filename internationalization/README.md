Declare the messages.properties as default and other
languages in resources folder

These get autowired as messagesource bean available in application-context

Service class uses this messagesource bean to get data from the message 
resource bundle

http://localhost:8080/messages?code=greeting&lang=fr
http://localhost:8080/messages?code=greeting&lang=en