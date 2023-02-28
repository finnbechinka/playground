using System;
using System.Collections.Generic;
using System.IO;

namespace Twist
{
    class Program
    {
        static void Main(string[] args)
        {
            twister(fileSelect());
            Console.ReadLine();
        }

        static void twister(List<String> rawWords)
        {
            char[] special = { ',', '.', '!', '?', '"', '(', ')' };
            List<String> words = new List<String>();
            foreach(String word in rawWords)
            {
                foreach (Char c in special)
                {
                    if (word.StartsWith(c))
                    {
                        words.Add(Char.ToString(c));
                    }
                }
                words.Add(word.Trim(special));
                foreach (Char c in special)
                {
                    if (word.EndsWith(c))
                    {
                        words.Add(Char.ToString(c));
                    }
                }
            }
        }

        static List<String> fileSelect()
        {
            Console.WriteLine("Select the file to be twisted (1-5): ");
            string selection = Console.ReadLine();
            List<String> words = new List<string>();
            List<String> lines;

            switch (selection)
            {
                case "1":
                    lines = new List<String>(File.ReadAllLines(@"C:\Users\finn-\Documents\bwinf material\twist\twist1.txt"));
                    foreach(String line in lines){
                        words.AddRange(line.Split(null));
                    }
                    return words;
                case "2":
                    lines = new List<String>(File.ReadAllLines(@"C:\Users\finn-\Documents\bwinf material\twist\twist2.txt"));
                    foreach (String line in lines)
                    {
                        words.AddRange(line.Split(null));
                    }
                    return words;
                case "3":
                    lines = new List<String>(File.ReadAllLines(@"C:\Users\finn-\Documents\bwinf material\twist\twist3.txt"));
                    foreach (String line in lines)
                    {
                        words.AddRange(line.Split(null));
                    }
                    return words;
                case "4":
                    lines = new List<String>(File.ReadAllLines(@"C:\Users\finn-\Documents\bwinf material\twist\twist4.txt"));
                    foreach (String line in lines)
                    {
                        words.AddRange(line.Split(null));
                    }
                    return words;
                case "5":
                    lines = new List<String>(File.ReadAllLines(@"C:\Users\finn-\Documents\bwinf material\twist\twist5.txt"));
                    foreach (String line in lines)
                    {
                        words.AddRange(line.Split(null));
                    }
                    return words;
                default:
                    Console.Out.WriteLine("Please only enter numbers between 1 and 5!");
                    return fileSelect();
            }
        }
    }
}
