# Carton

Carton is a smart grocery list that will save you money, save you time, and save you food poisoning by keeping track of the food in your kitchen and various analytics such as how much you use of a certain item, how often you have to buy it, how much you spend, and how long a certain item is good for.

## MVP

An application where the user can:
* Input their grocery receipts via phone camera
* Record patterns in grocery shopping
* Create Account
* Store and Display info regarding image, date, quantity, price, etc.
* Create automatic report of expenses

### Prerequisites

* A favorite text editor (my personal favorite is Atom but [Visual Studio Code](https://code.visualstudio.com/) is also very good) 
* [Android Studio?](https://developer.android.com/studio?gclid=CjwKCAjwtuLrBRAlEiwAPVcZBnaJh-7mslFoX6ZQf1OcGRBegjOz8tiaV1wULCd7PPD02tMssnK7uBoCHHcQAvD_BwE)
* [React](https://code.visualstudio.com/)
* GitHub

### Technology Stack Choices

* Receipt OCR. There are two possible API’s to do this, both are free or have free trials: [ReceiptBank](https://www.receipt-bank.com/receipt-scanning-api/) and [OCR Space](https://ocr.space/receiptscanning)
* MongoDB. For storing state because it is open-source and NoSQL which will make it flexible-enough for our needs, and we can use it for free at our scale


| Desktop  |    Mobile     | Web   |
| -------- | ------------- |------ |
| Electron | React Native  | React |

## Milestones

1)    Create teams for front-end and back-end
2)    Learn technologies
3)    Front-End completes wireframe
4)    Front-end and Back-End begin development on tasks
5)    Integration of Front-end and Back-End
6)    Final Draft
7)    Finishing Touches
8)    Presentation


### Foreseeable Roadblocks

* Integration of both Front-End and Back-End technologies. This will be solved through trial and error and guidance if needed.
* Differentiating date types on receipts e.g. xx/xx/xxxx, xx/xx/xx, xx-xx-xxxx. This will solved with API calls.
* Getting started on research and practice of new technologies. This will be done naturally through the course of the 10 weeks.


### Future Extensions

* Start making smart recommendations for changes to your habits based on these metrics
* Create a notification system notifying the user when something needs to be bought soon
* Linked account registration for live list update


