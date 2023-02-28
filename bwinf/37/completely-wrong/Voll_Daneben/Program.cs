using System;

namespace Voll_Daneben
{
    class Program
    {
        static void Main(string[] args)
        {
            checkWinnings(selectFile());
            Console.ReadLine();
        }

        static void checkWinnings(string[] input)
        {
            int[] numbers = Array.ConvertAll(input, int.Parse);

            int x = 0;

            for (int i = 0; i < input.Length; i++)
            {
                x += numbers[i];
            }

            Console.WriteLine(x);
        }

        static string[] readInput(int x)
        {
            switch (x)
            {
                case 1:
                    string[] file1 = System.IO.File.ReadAllLines(@"C:\Users\finn-\Documents\bwinf material\voll daneben\beispiel1.txt");
                    return file1;
                case 2:
                    string[] file2 = System.IO.File.ReadAllLines(@"C:\Users\finn-\Documents\bwinf material\voll daneben\beispiel2.txt");
                    return file2;
                case 3:
                    string[] file3 = System.IO.File.ReadAllLines(@"C:\Users\finn-\Documents\bwinf material\voll daneben\beispiel3.txt");
                    return file3;
                default:
                    return null;
            }
        }

        static string[] selectFile()
        {
            Console.WriteLine("Select a file (1,2,3):");
            int selection = Convert.ToInt32(Console.ReadLine());

            switch (selection)
            {
                case 1:
                    return readInput(1);
                case 2:
                    return readInput(2);
                case 3:
                    return readInput(3);
                default:
                    return null;
            }
        }
    }
}