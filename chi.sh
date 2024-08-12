echo start child

function wait() {
  for i in `seq 1 $1`; do echo "$2: THIS IS LOOP $i"; sleep 1; done
}

trap 'echo trap start; wait 5 "trap"; echo trap finished ;exit 1' 15

echo "PID: kill -15 $BASHPID"
wait 30 "main"

echo finish child