package com.eshikhon;

public class Class17 {
    public static void main(String[] args) {

        /*
        * Created - C // insert into ..
        * Read - R // select ..
        * Update - U // update ... where ...
        * Delete - D // delete ... where ...
        *
        * CRUD
        *
        * */

        /*
        * Create database
        * Create table
        * primary --> auto increment
        *
        * */
        /*

        create table person_info(
            id int auto_increment primary key,
            name varchar(50),
            age int,
            address varchar(400),
            email varchar(50)
        );
        insert into person_info
        (name, age, address, email)
        values ('ali', 25, 'dhaka', 'kz@gmail.com');

        insert into person_info
        (name, age, address, email)
        values ('KZ', 40, 'dhaka', 'kz@gmail.com');


        select *
        from person_info

        where age >= 15 or age < 30;

        update person_info
        set
        address = 'dhaka',
        email = 'email@kmail.com'

        where id = 22;

        delete from person_info
        where id = 2;
        * */
    }
}
