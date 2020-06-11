from time import time_ns

class Tester:
    def __init__(self, task, path):
        self.task = task
        self.path = path

    def check_all(self):
        nr = 0

        while True:
            try:
                in_file = f'{self.path}/test.{nr}.in'
                out_file = f'{self.path}/test.{nr}.out'

                self.run_test(in_file, out_file, nr)
                nr += 1
            except FileNotFoundError:
                return
            except Exception as err:
                print(err)

    def run_test(self, in_file, out_file, num):
        in_lines = open(in_file, 'r').readlines()
        out_lines = open(out_file, 'r').readlines()

        expected = out_lines[0].strip()
        begin = time_ns()
        actual = self.task(in_lines)
        if actual is None:
            return
        end = time_ns()

        if expected == actual:
            print(f'Test #{num} is PASSED')
            print(f'Elapsed time: {end - begin}')
            return

        print(f'Test #{num} is FAILED! Expected: {expected}, but actual: {actual}')