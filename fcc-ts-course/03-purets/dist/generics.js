"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const score = Array();
const names = Array();
function identity(val) {
    return val;
}
function any_identity(val) {
    return val;
}
// function generic_identity<Type>(val: Type): Type {
//   return val;
// }
function generic_identity(val) {
    return val;
}
generic_identity(3);
generic_identity("3");
generic_identity({});
function get_search_products(ids) {
    return ids[3];
}
const get_mode = (arr) => {
    return arr[1];
};
function fn(val1, val2) {
    return { val1, val2 };
}
class Sellable {
    constructor() {
        this.cart = [];
    }
    add_to_cart(product) {
        this.cart.push(product);
    }
}
