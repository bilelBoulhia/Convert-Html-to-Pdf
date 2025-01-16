# Convert HTML to PDF

 Java CLI application for converting HTML documents into PDF files.

## Getting Started

To run this project locally, follow these steps:

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/bilelBoulhia/Convert-Html-to-Pdf.git
   ```

2. **Navigate to the Project Directory**:
   ```bash
   cd Convert-Html-to-Pdf
   ```

3. **Build the Project**:
   Ensure you have Maven installed, then run:
   ```bash
   mvn clean install
   ```

4. **Run the Application**:
   After building the project, you can run the application using:
   ```bash
   java -jar target/ConvertHP_Cli-1.0-SNAPSHOT.jar
   ```
   Replace the command arguments as necessary based on the application's usage.

## Dependencies

This project uses the following dependencies:

- **JUnit** (3.8.1): For testing purposes.
- **Picocli** (4.7.6): For building the command-line interface.
- **Flying Saucer** (9.1.22): For rendering and converting HTML to PDF.
- **Jsoup** (1.13.1): For parsing and manipulating HTML.
- **SLF4J** (1.7.30): For logging.
- **Commons IO** (2.11.0): For working with file streams and utilities.

## Prerequisites

- [Java JDK](https://www.oracle.com/java/technologies/javase-downloads.html) (version 8 or higher)
- [Apache Maven](https://maven.apache.org/)

## Features

- Convert HTML files to PDF format.
- Supports custom styling and formatting using CSS.
- Command-line interface for ease of use.

