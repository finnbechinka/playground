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
  private _count = 0;
  city: string = "";
  constructor(public email: string, public name: string) {}

  private gol() {
    console.log("gol");
  }

  get get_email(): string {
    return this.email;
  }

  get get_count(): number {
    return this._count;
  }

  set set_count(c: number) {
    if (c < 0) {
      throw new Error("count less than 0");
    }
    this._count = c;
  }
}

const user = new User("email", "finn");
user.city = "berlin";
