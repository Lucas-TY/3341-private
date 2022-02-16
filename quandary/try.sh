# ./grading/grade.sh skeleton/myproject.tgz  ref/quandary grading/simplified-without-calls-public.dat  examples
# skeleton/quandary ./examples/test.q -10
cd skeleton
make clean
make submission
make
cd ..
skeleton/quandary ./examples/test.q -10