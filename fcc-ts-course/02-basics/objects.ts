// const user = {
//   name: "Finn",
//   email: "finn@email.com",
//   is_active: true,
// };

// function create_user({ name: string, is_paid: boolean }) {}

// let usr = { name: "Finn", is_paid: false, email: "f@e.com" };

// create_user(usr);

// function create_course(): { name: string; price: number } {
//   return { name: "Finn", price: 30 };
// }

// type User = {
//   name: string;
//   email: string;
//   is_active: boolean;
// };

// function create_user(user: User): User {
//   return { name: "", email: "", is_active: true };
// }

type User = {
  readonly _id: string;
  name: string;
  email: string;
  is_active: boolean;
  payment_info?: PaymentDetails;
};

type PaymentDetails = {
  type: string;
  id: number;
  date: string;
};
type OtherUser = User & Partial<PaymentDetails>;

let my_user: User = {
  _id: "123",
  name: "",
  email: "",
  is_active: false,
};

export {};
