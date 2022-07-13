
### Framework
Framework is top most component of the application which is used by bank application and credit card application.
It have implemented different design pattern like command, observer, party, account, account factory and singleton.

### FinCoView
FinCoView is the default JFrame view (UI) for the framework. It can be extended by the bank application and credit card application.
The FinCoView provides must common functionalities and client can extends those and add more on it.

### Command
It is an interface for a command. Client can send different command which is invoked by a finco operation manager.

##Account Service
This is service for account related activities. It works for communication for view and operation manager. It creates appropriate command as for view request
and send its to operation manager.

## Customer Service
This is service for customer related activities.

##FincoReceiver
Finco Receiver is a main class which is responsible for holding all related accounts and customers information. The command use
the finco receiver for delegation of works that are sends by a client. Finco receiver is also subject, when something changed in it it notify a view
to update.

##Different Design Pattern used
Observer Pattern: FincoReceiver as Subject and View as Observer
Factory Design Pattern: Bank Factory for creating different type of bank account like checking account and saving account
Command Design Pattern: Command are send as per different request from view by a operation manager to do some operation on FincoReceiver
Singleton Design Pattern: EmailSender use a singleton design pattern to send email to particular customer
