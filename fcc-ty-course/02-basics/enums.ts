// const AISLE = 0
// const MIDDLE = 1
// const WINDOW = 2

// var Seat;
// (function (Seat) {
//     Seat[Seat["AISLE"] = 0] = "AISLE";
//     Seat[Seat["MIDDLE"] = 1] = "MIDDLE";
//     Seat[Seat["WINDOW"] = 2] = "WINDOW";
// })(Seat || (Seat = {}));
// var a = Seat.AISLE;
// var b = Seat.MIDDLE;
// =
// enum Seat {
//   AISLE,
//   MIDDLE,
//   WINDOW,
// }

// var a = 0 /* Seat.AISLE */;
// var b = 1 /* Seat.MIDDLE */;
// =
const enum Seat {
  AISLE,
  MIDDLE,
  WINDOW,
}

let a = Seat.AISLE;
let b = Seat.MIDDLE;

export {};
