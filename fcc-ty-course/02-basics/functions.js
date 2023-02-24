function add_two(num) {
    return num + 2;
}
function get_upper(val) {
    return val.toUpperCase();
}
function sign_up(name, email, is_paid) { }
function login(name, email, is_paid) {
    if (is_paid === void 0) { is_paid = false; }
}
add_two(5);
get_upper("how");
sign_up("Chad", "das", true);
login("Chad", "das");
function get_value(val) {
    if (val > 5) {
        return true;
    }
    return "OK";
}
var get_hello_fn = function (s) { return s; };
var heroes = ["thor", "spiderman", "ironman"];
heroes.map(function (hero) {
    return "hero is ".concat(hero, ".");
});
function console_err(msg) {
    console.log(msg);
}
function handle_err(msg) {
    throw new Error(msg);
}
