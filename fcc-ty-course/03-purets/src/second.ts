interface TakePhoto {
  mode: string;
  filter: string;
  burst: number;
}

class Insta implements TakePhoto, Story {
  constructor(public mode: string, public filter: string, public burst: number) {}
  create_story(): void {
    console.log("");
  }
}

interface Story {
  create_story(): void;
}
