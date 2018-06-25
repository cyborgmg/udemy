import { Person } from './../lesson01-classes/person';
import { DaoInterface } from './dao.interface';
import { Dao } from './dao';

let dao: DaoInterface<Person> = new Dao<Person>();
let person = new Person('Mike');

dao.insert(person);