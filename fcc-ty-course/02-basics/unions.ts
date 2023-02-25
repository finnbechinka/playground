let score: number | string = 33;

score = 44;
score = "55";

type User = {
  name: string;
  id: number;
};

type Admin = {
  username: string;
  id: number;
};

let finn: User | Admin = { name: "finn", id: 1 };
finn = { username: "shaker", id: 1 };

function get_db_id(id: number | string) {
  if (typeof id === "string") {
    id.toLocaleLowerCase();
  }
  console.log(`db id is : ${id}`);
}
get_db_id(2);
get_db_id(3);

const data: (number | string)[] = [1, 2, 3, "4"];

let seat_allotment: "aisle" | "middle" | "window";
seat_allotment = "aisle";
// seat_allotment = "oof";

export {};
