function add_two(num: number): number {
  return num + 2;
}

function get_upper(val: string) {
  return val.toUpperCase();
}

function sign_up(name: string, email: string, is_paid: boolean) {}
function login(name: string, email: string, is_paid: boolean = false) {}

add_two(5);
get_upper("how");
sign_up("Chad", "das", true);
login("Chad", "das");

function get_value(val: number) {
  if (val > 5) {
    return true;
  }
  return "OK";
}

const get_hello_fn = (s: string): string => s;

const heroes = ["thor", "spiderman", "ironman"];

heroes.map((hero): string => {
  return `hero is ${hero}.`;
});

function console_err(msg: string): void {
  console.log(msg);
}

function handle_err(msg: string): never {
  throw new Error(msg);
}

export {};
