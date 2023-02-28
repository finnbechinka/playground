interface User {
  readonly id: number;
  email?: string;
  // start_trail: () => string;
  start_trail?(): string;
  get_coupon(name: string): number;
}

const finn: User = { email: "email", id: 0, get_coupon: (n: "h") => 5 };

interface User {
  token?: string;
}

interface Admin extends User {
  role: "admin" | "ta";
}

export {};
