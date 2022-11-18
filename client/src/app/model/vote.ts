import { Poll } from "./Poll";
import { User } from "./User";

export interface Vote{
  voteId: number;
  user: User;
  date: Date;
  voter: User;
  poll: Poll;
}
