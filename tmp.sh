#!/bin/bash

echo "Skosztujcie i zobaczcie" > i.txt
if grep -o "zobaczcie" i.txt && grep -o "i" i.txt
then
    echo "TAK"
else
    echo "NIE"
fi
