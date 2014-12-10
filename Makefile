# so i took this from that(link) and i am pretty much sure this can remain same and or we can make few changes to this but the
## first few lines could be like this



MAKEFLAGS += --no-print-directory

PATH := $(CURDIR)/vendor/local/bin:$(PATH)
CLASSPATH := .

JAVASCRIPT := $(shell which rhino nodejs node js 2>/dev/null | head -1)
ifeq ($(JAVASCRIPT),)
  $(warning JavaScript interpreter not found!)
endif

SCHEME := $(shell which guile csi gosh 2>/dev/null | head -1)
ifeq ($(SCHEME),)
  $(warning Scheme interpreter not found!)
endif
ifeq ($(SCHEME),$(shell which csi 2>/dev/null | head -1))
  SCHEME := csi -s
endif

BF := $(shell which bf beef 2>/dev/null | head -1)
ifeq ($(BF),)
  $(warning Brainfuck interpreter not found!)
endif


## Lemme know if this looks good ? or any comment on this?
