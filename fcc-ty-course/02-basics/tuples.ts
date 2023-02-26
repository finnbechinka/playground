// const user: string[] = ["hc"]
const user: [string, number, boolean] = ["hc", 1, true];

const rgb: [number, number, number] = [255, 255, 255];

// type User = [number, string];
type User = readonly [number, string];

const new_user: User = [112, "email"];
// new_user[1] = "new email";
// new_user.push(1);

console.log(new_user);

export {};
