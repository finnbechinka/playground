const score = Array<number>();
const names = Array<string>();

function identity(val: boolean | number): boolean | number {
  return val;
}

function any_identity(val: any): any {
  return val;
}

// function generic_identity<Type>(val: Type): Type {
//   return val;
// }

function generic_identity<T>(val: T): T {
  return val;
}

generic_identity(3);
generic_identity("3");

interface Bottle {
  brand?: string;
  type?: number;
}

generic_identity<Bottle>({});

function get_search_products<T>(ids: T[]): T {
  return ids[3];
}

const get_mode = <T>(arr: T[]): T => {
  return arr[1];
};

// function fn<T, U extends number>(val1: T, val2: U): object {
//   return { val1, val2 };
// }

// fn("1", 2);

interface Database {
  conn: string;
  username: string;
  password: string;
}

function fn<T, U extends Database>(val1: T, val2: U): object {
  return { val1, val2 };
}

interface Quizz {
  name: string;
  type: string;
}

interface Course {
  name: string;
  author: string;
  subject: string;
}

class Sellable<T extends Quizz | Course> {
  public cart: T[] = [];

  add_to_cart(product: T) {
    this.cart.push(product);
  }
}

export {};
