# TODO LIST APP

This is an example TODO List app using Room for data persistence.

# Features

Users are able to add, delete, and edit todos. 

Each todo item contains a title, and optionally a description, for cases where the user wants to be more descriptive with the item they want to complete.

# Architecture

The Architecture used was MVVVM, with UIEvents driving user/app ineraction, giving it an MVI twist.

Manual dependency injection was used, in order to avoid using any third party libraries. One interesting improvement would be to add a DI module in order to compartmentalize that responsibility. 

# Dependencies

The only third dependency used was Room. No other third party dependencies were used

# Testing

Core classes have been abstracted out, stubbed and mocked for testing and modularity purposes
All important classes have been abstracted out so that they can be stubbed, mocked and used for testing.

In order to validate the functionality created with Room, instrumented tests were used for database coverage.



