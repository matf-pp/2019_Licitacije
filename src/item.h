#ifndef ITEM
#define ITEM
#include<string>
#include<time.h>


struct Item
{
    double price;
    string names;
    tm ending_time;    
};
Item::Item(){}
Item::~Item(){}
#endif