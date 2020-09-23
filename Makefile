CLASSES = \
	Board

default:
	javac -g -d . source/$(CLASSES).java

run: default
	java main.java
