📝 **Todo List Console Application**

This is a simple console-based ToDo list application built using Java. It allows users to manage their tasks efficiently.

### Features
📋 Click to Display Data: Core functionality for viewing to-do items.  
➕ Add New Todo List: Create and add new tasks.  
✏️ Edit Existing Todo List: Modify tasks as needed.  
❌ Delete Existing Todo List: Remove completed or irrelevant tasks.  
🔍 Search Existing Todo List: Locate specific tasks using the following search parameters:
- Task content
- Completion status (isDone)

### Technical Overview
- **TodoListDataSource:** A configuration class providing a static ArrayList as a basic data source for the Todo List repository.

### Getting Started
**Prerequisites:**
- Java Development Kit (JDK): [Download JDK](https://www.oracle.com/java/technologies/downloads/) (version X or later)
- Build tool (Maven or Gradle): [Maven](https://maven.apache.org/) | [Gradle](https://gradle.org/)
- Web Server (Embedded like Tomcat or standalone): [Tomcat](https://tomcat.apache.org/)

**Installation:**
1. Clone this repository.
2. Build the project using your chosen build tool (e.g., `mvn clean install`).
3. Deploy the resulting artifact (typically a .war file) to your web server.

### Usage
1. Start the web server.
2. Access the application in your web browser, typically at [http://localhost:8080/](http://localhost:8080/) (adjust the port as needed).

### API Endpoints
- GET `/todo` - Displays all todo-list items.
- GET `/todo/{id}` - Displays a todo-list item by ID.
- GET `/todo/new` - Provides a form to add a new todo-list item.
- GET `/todo/edit/{id}` - Provides a form to edit a todo-list item by ID.
- GET `/todo/delete/{id}` - Deletes a todo-list item by ID.
- GET `/todo/search` - Searches todo-list items by task and isDone (`?task=someTaskText&isDone=true/false`)

