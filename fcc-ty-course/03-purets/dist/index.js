"use strict";
// class User {
//   private email: string;
//   name: string;
//   city: string = "";
//   constructor(email: string, name: string) {
//     this.email = email;
//     this.name = name;
//   }
// }
class User {
    constructor(email, name) {
        this.email = email;
        this.name = name;
        this._count = 0;
        this.city = "";
    }
    gol() {
        console.log("gol");
    }
    get get_email() {
        return this.email;
    }
    get get_count() {
        return this._count;
    }
    set set_count(c) {
        if (c < 0) {
            throw new Error("count less than 0");
        }
        this._count = c;
    }
}
const user = new User("email", "finn");
user.city = "berlin";
