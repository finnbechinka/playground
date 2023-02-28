"use strict";
function detect_type(val) {
    if (typeof val === "string") {
        return val.toLocaleLowerCase();
    }
    return val + 3;
}
function provide_id(id) {
    if (!id) {
        console.log("haha");
        return;
    }
    return id.toLocaleLowerCase();
}
function is_admin(acc) {
    if ("is_admin" in acc) {
        return acc.is_admin;
    }
    return false;
}
function logValue(x) {
    if (x instanceof Date) {
        console.log(x.toUTCString());
    }
    else {
        console.log(x.toUpperCase());
    }
}
// function isFish(pet: Fish | Bird): boolean {
//   return (pet as Fish).swim !== undefined;
// }
function isFish(pet) {
    return pet.swim !== undefined;
}
function get_food(pet) {
    if (isFish(pet)) {
        pet;
        return "fish food";
    }
    else {
        pet;
        return "bird food";
    }
}
function get_shape(shape) {
    if (shape.kind === "circle") {
        return Math.PI * shape.radius ** 2;
    }
    if (shape.kind == "rectangle") {
        return shape.length * shape.width;
    }
    return shape.side ** 2;
}
function get_area(shape) {
    switch (shape.kind) {
        case "circle":
            return Math.PI * shape.radius ** 2;
        case "square":
            return shape.side ** 2;
        case "rectangle":
            return shape.length * shape.width;
        default:
            const _exhausive_check = shape;
            return _exhausive_check;
    }
}
