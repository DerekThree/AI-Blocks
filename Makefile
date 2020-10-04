CLASSES = \
	Board.java \
	Node.java \
	Fringe.java \
	Agent.java

all: classes input
	java main.java < input

run:
	java main.java < input

driver: classes
	java driver.java

input:
	touch input

classes: utils $(CLASSES:.java=.class)

utils:
	javac -g -d . Utils.java

clean:
	$(RM) *.class

JFLAGS = -g -d .
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java
