abstract class TakePhoto {
  constructor(public mode: string, public filter: string) {}

  abstract method(): void;
  get_num(): number {
    return 0;
  }
}

// const x = new TakePhoto("a", "b");

class Insta extends TakePhoto {
  constructor(public mode: string, public filter: string) {
    super(mode, filter);
  }

  method(): void {}
}

export {};
