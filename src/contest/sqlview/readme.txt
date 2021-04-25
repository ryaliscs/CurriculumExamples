SQL View Creater

This execise is to create a SQL View based on columns from multiple tables.

The user Enters a Parent/Base table name and its columns
The user enters how many children tables are required to create a view.  Max allowed tables 3
And for each table input should be table_name, columns in the table. Columns in children table can be all or subset columns from the parent table columns only.
Create a view by joining all the tables
The columns in the view should be in sorted order

eg 1:
Enter the Parent table name: Person
Enter the table columns:
firstName
lastName
qualitification
fatherName
departmentName
no_of_dependents
date_of_joining
address1
address2
street
city
state

Enter No. of tables: 3
Enter Table Name: employee
Enter the table columns:
firstName
lastName
qualitification
no_of_dependents
date_of_joining

Enter Table Name: student
Enter the table columns:
firstName
lastName
fatherName
qualitification
departmentName
date_of_joining

Enter Table Name: addressbook
Enter the table columns:
address1
address2
street
city
state

Output:
CREATE OR REPLACE VIEW PERSON 
(
	firstName,
	lastName,
	qualitification,
	fatherName,
	departmentName,
	no_of_dependents,
	date_of_joining,
	address1,
	address2,
	street,
	city,
	state,
)
As
SELECT 
	firstName,
	lastName,
	qualitification,
	null as fatherName,
	null as departmentName,
	no_of_dependents,
	date_of_joining,
	null as address1,
	null as address2,
	null as street,
	null as city,
	null as state,
FROM EMPLOYEE
UNION ALL
SELECT 
	firstName,
	lastName,
	qualitification,
	fatherName,
	departmentName,
	null as no_of_dependents,
	date_of_joining,
	null as address1,
	null as address2,
	null as street,
	null as city,
	null as state,
FROM STUDENT
UNION ALL
SELECT 
	null as firstName,
	null as lastName,
	null as qualitification,
	null as fatherName,
	null as departmentName,
	null as no_of_dependents,
	null as date_of_joining,
	address1,
	address2,
	street,
	city,
	state,
FROM ADDRESSBOOK

eg 1:
Enter the Parent table name: Person
Enter the table columns:
firstName
lastName
qualitification
fatherName
departmentName
no_of_dependents
date_of_joining
address1
address2
street
city
state

Enter No. of tables: 2
Enter Table Name: employee
Enter the table columns:
firstName
lastName
grade
qualitification
no_of_dependents
date_of_joining

Output:
The column "grade" is not allowed as it is not defined in parent table "Person"

