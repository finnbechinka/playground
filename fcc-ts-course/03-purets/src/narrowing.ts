function detect_type(val: number | string) {
  if (typeof val === "string") {
    return val.toLocaleLowerCase();
  }
  return val + 3;
}

function provide_id(id: string | null) {
  if (!id) {
    console.log("haha");
    return;
  }
  return id.toLocaleLowerCase();
}

interface User {
  name: string;
  email: string;
}

interface Admin {
  name: string;
  email: string;
  is_admin: boolean;
}

function is_admin(acc: User | Admin) {
  if ("is_admin" in acc) {
    return acc.is_admin;
  }
  return false;
}

function logValue(x: Date | string) {
  if (x instanceof Date) {
    console.log(x.toUTCString());
  } else {
    console.log(x.toUpperCase());
  }
}

type Fish = { swim: () => void };
type Bird = { fly: () => void };

// function isFish(pet: Fish | Bird): boolean {
//   return (pet as Fish).swim !== undefined;
// }

function isFish(pet: Fish | Bird): pet is Fish {
  return (pet as Fish).swim !== undefined;
}

function get_food(pet: Fish | Bird) {
  if (isFish(pet)) {
    pet;
    return "fish food";
  } else {
    pet;
    return "bird food";
  }
}

interface Circle {
  kind: "circle";
  radius: number;
}

interface Square {
  kind: "square";
  side: number;
}

interface Rectangle {
  kind: "rectangle";
  length: number;
  width: number;
}

type Shape = Circle | Square | Rectangle;

function get_shape(shape: Shape) {
  if (shape.kind === "circle") {
    return Math.PI * shape.radius ** 2;
  }
  if (shape.kind == "rectangle") {
    return shape.length * shape.width;
  }
  return shape.side ** 2;
}

function get_area(shape: Shape) {
  switch (shape.kind) {
    case "circle":
      return Math.PI * shape.radius ** 2;
    case "square":
      return shape.side ** 2;
    case "rectangle":
      return shape.length * shape.width;
    default:
      const _exhausive_check: never = shape;
      return _exhausive_check;
  }
}
