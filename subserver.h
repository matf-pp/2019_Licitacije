#include <vector>
#include "item.h"
#include "client.h"
using namespace std;

private 
class Subserver
{
private:
    vector<Item> items;
    vector<Client> clients;
public:
    Subserver(/* args */);
    ~Subserver();
};

Subserver::Subserver(/* args */)
{
}

Subserver::~Subserver()
{
}
