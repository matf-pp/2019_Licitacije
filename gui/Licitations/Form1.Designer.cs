namespace Licitations
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.label_username = new System.Windows.Forms.Label();
            this.textBox_username = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.label_password = new System.Windows.Forms.Label();
            this.textBox_password = new System.Windows.Forms.TextBox();
            this.button_connect = new System.Windows.Forms.Button();
            this.panel_connection = new System.Windows.Forms.Panel();
            this.panel_bidding = new System.Windows.Forms.Panel();
            this.label_money2 = new System.Windows.Forms.Label();
            this.label_currentMoney = new System.Windows.Forms.Label();
            this.label_money = new System.Windows.Forms.Label();
            this.textBox_moneyAdd = new System.Windows.Forms.TextBox();
            this.button_moneyAdd = new System.Windows.Forms.Button();
            this.label_itemsOfInterest = new System.Windows.Forms.Label();
            this.button_listOffers = new System.Windows.Forms.Button();
            this.richTextBox_offer = new System.Windows.Forms.RichTextBox();
            this.label_selectedOffer = new System.Windows.Forms.Label();
            this.label_myItems = new System.Windows.Forms.Label();
            this.button_disconnect = new System.Windows.Forms.Button();
            this.panel_offers = new System.Windows.Forms.Panel();
            this.richTextBox1 = new System.Windows.Forms.RichTextBox();
            this.panel_connection.SuspendLayout();
            this.panel_bidding.SuspendLayout();
            this.panel_offers.SuspendLayout();
            this.SuspendLayout();
            // 
            // label_username
            // 
            this.label_username.AutoSize = true;
            this.label_username.Location = new System.Drawing.Point(16, 22);
            this.label_username.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label_username.Name = "label_username";
            this.label_username.Size = new System.Drawing.Size(55, 13);
            this.label_username.TabIndex = 0;
            this.label_username.Text = "Username";
            // 
            // textBox_username
            // 
            this.textBox_username.Location = new System.Drawing.Point(97, 18);
            this.textBox_username.Margin = new System.Windows.Forms.Padding(2);
            this.textBox_username.Name = "textBox_username";
            this.textBox_username.Size = new System.Drawing.Size(76, 20);
            this.textBox_username.TabIndex = 1;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(26, 57);
            this.label2.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(0, 13);
            this.label2.TabIndex = 2;
            // 
            // label_password
            // 
            this.label_password.AutoSize = true;
            this.label_password.Location = new System.Drawing.Point(16, 51);
            this.label_password.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label_password.Name = "label_password";
            this.label_password.Size = new System.Drawing.Size(53, 13);
            this.label_password.TabIndex = 3;
            this.label_password.Text = "Password";
            // 
            // textBox_password
            // 
            this.textBox_password.Location = new System.Drawing.Point(97, 47);
            this.textBox_password.Margin = new System.Windows.Forms.Padding(2);
            this.textBox_password.Name = "textBox_password";
            this.textBox_password.Size = new System.Drawing.Size(76, 20);
            this.textBox_password.TabIndex = 4;
            // 
            // button_connect
            // 
            this.button_connect.Location = new System.Drawing.Point(65, 88);
            this.button_connect.Margin = new System.Windows.Forms.Padding(2);
            this.button_connect.Name = "button_connect";
            this.button_connect.Size = new System.Drawing.Size(56, 19);
            this.button_connect.TabIndex = 5;
            this.button_connect.Text = "Connect";
            this.button_connect.UseVisualStyleBackColor = true;
            this.button_connect.Click += new System.EventHandler(this.button1_Click);
            // 
            // panel_connection
            // 
            this.panel_connection.Controls.Add(this.textBox_username);
            this.panel_connection.Controls.Add(this.button_connect);
            this.panel_connection.Controls.Add(this.label_username);
            this.panel_connection.Controls.Add(this.textBox_password);
            this.panel_connection.Controls.Add(this.label_password);
            this.panel_connection.Location = new System.Drawing.Point(58, 24);
            this.panel_connection.Margin = new System.Windows.Forms.Padding(2);
            this.panel_connection.Name = "panel_connection";
            this.panel_connection.Size = new System.Drawing.Size(657, 478);
            this.panel_connection.TabIndex = 6;
            this.panel_connection.Paint += new System.Windows.Forms.PaintEventHandler(this.panel_connection_Paint);
            // 
            // panel_bidding
            // 
            this.panel_bidding.Controls.Add(this.panel_offers);
            this.panel_bidding.Controls.Add(this.button_disconnect);
            this.panel_bidding.Controls.Add(this.label_myItems);
            this.panel_bidding.Controls.Add(this.label_selectedOffer);
            this.panel_bidding.Controls.Add(this.richTextBox_offer);
            this.panel_bidding.Controls.Add(this.button_listOffers);
            this.panel_bidding.Controls.Add(this.label_itemsOfInterest);
            this.panel_bidding.Controls.Add(this.button_moneyAdd);
            this.panel_bidding.Controls.Add(this.textBox_moneyAdd);
            this.panel_bidding.Controls.Add(this.label_money2);
            this.panel_bidding.Controls.Add(this.label_currentMoney);
            this.panel_bidding.Controls.Add(this.label_money);
            this.panel_bidding.Location = new System.Drawing.Point(29, 24);
            this.panel_bidding.Name = "panel_bidding";
            this.panel_bidding.Size = new System.Drawing.Size(654, 464);
            this.panel_bidding.TabIndex = 6;
            // 
            // label_money2
            // 
            this.label_money2.AutoSize = true;
            this.label_money2.Location = new System.Drawing.Point(16, 47);
            this.label_money2.Name = "label_money2";
            this.label_money2.Size = new System.Drawing.Size(60, 13);
            this.label_money2.TabIndex = 2;
            this.label_money2.Text = "Add money";
            // 
            // label_currentMoney
            // 
            this.label_currentMoney.AutoSize = true;
            this.label_currentMoney.Location = new System.Drawing.Point(189, 18);
            this.label_currentMoney.Name = "label_currentMoney";
            this.label_currentMoney.Size = new System.Drawing.Size(13, 13);
            this.label_currentMoney.TabIndex = 1;
            this.label_currentMoney.Text = "0";
            this.label_currentMoney.Click += new System.EventHandler(this.label_currentMoney_Click);
            // 
            // label_money
            // 
            this.label_money.AutoSize = true;
            this.label_money.Location = new System.Drawing.Point(16, 18);
            this.label_money.Name = "label_money";
            this.label_money.Size = new System.Drawing.Size(84, 13);
            this.label_money.TabIndex = 0;
            this.label_money.Text = "Avaliable money";
            // 
            // textBox_moneyAdd
            // 
            this.textBox_moneyAdd.Location = new System.Drawing.Point(102, 40);
            this.textBox_moneyAdd.Name = "textBox_moneyAdd";
            this.textBox_moneyAdd.Size = new System.Drawing.Size(100, 20);
            this.textBox_moneyAdd.TabIndex = 3;
            // 
            // button_moneyAdd
            // 
            this.button_moneyAdd.Location = new System.Drawing.Point(230, 38);
            this.button_moneyAdd.Name = "button_moneyAdd";
            this.button_moneyAdd.Size = new System.Drawing.Size(75, 23);
            this.button_moneyAdd.TabIndex = 4;
            this.button_moneyAdd.Text = "Add";
            this.button_moneyAdd.UseVisualStyleBackColor = true;
            // 
            // label_itemsOfInterest
            // 
            this.label_itemsOfInterest.AutoSize = true;
            this.label_itemsOfInterest.Location = new System.Drawing.Point(32, 126);
            this.label_itemsOfInterest.Name = "label_itemsOfInterest";
            this.label_itemsOfInterest.Size = new System.Drawing.Size(81, 13);
            this.label_itemsOfInterest.TabIndex = 5;
            this.label_itemsOfInterest.Text = "Items of interest";
            // 
            // button_listOffers
            // 
            this.button_listOffers.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.button_listOffers.Location = new System.Drawing.Point(331, 22);
            this.button_listOffers.Name = "button_listOffers";
            this.button_listOffers.Size = new System.Drawing.Size(140, 60);
            this.button_listOffers.TabIndex = 6;
            this.button_listOffers.Text = "List offers";
            this.button_listOffers.UseVisualStyleBackColor = true;
            // 
            // richTextBox_offer
            // 
            this.richTextBox_offer.Location = new System.Drawing.Point(192, 162);
            this.richTextBox_offer.Name = "richTextBox_offer";
            this.richTextBox_offer.Size = new System.Drawing.Size(207, 74);
            this.richTextBox_offer.TabIndex = 7;
            this.richTextBox_offer.Text = "";
            // 
            // label_selectedOffer
            // 
            this.label_selectedOffer.AutoSize = true;
            this.label_selectedOffer.Location = new System.Drawing.Point(256, 126);
            this.label_selectedOffer.Name = "label_selectedOffer";
            this.label_selectedOffer.Size = new System.Drawing.Size(73, 13);
            this.label_selectedOffer.TabIndex = 8;
            this.label_selectedOffer.Text = "Selected offer";
            // 
            // label_myItems
            // 
            this.label_myItems.AutoSize = true;
            this.label_myItems.Location = new System.Drawing.Point(495, 126);
            this.label_myItems.Name = "label_myItems";
            this.label_myItems.Size = new System.Drawing.Size(48, 13);
            this.label_myItems.TabIndex = 9;
            this.label_myItems.Text = "My items";
            // 
            // button_disconnect
            // 
            this.button_disconnect.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.button_disconnect.Location = new System.Drawing.Point(487, 22);
            this.button_disconnect.Name = "button_disconnect";
            this.button_disconnect.Size = new System.Drawing.Size(140, 60);
            this.button_disconnect.TabIndex = 10;
            this.button_disconnect.Text = "Disconnect";
            this.button_disconnect.UseVisualStyleBackColor = true;
            // 
            // panel_offers
            // 
            this.panel_offers.Controls.Add(this.richTextBox1);
            this.panel_offers.Location = new System.Drawing.Point(243, 440);
            this.panel_offers.Name = "panel_offers";
            this.panel_offers.Size = new System.Drawing.Size(200, 100);
            this.panel_offers.TabIndex = 6;
            // 
            // richTextBox1
            // 
            this.richTextBox1.Location = new System.Drawing.Point(0, 0);
            this.richTextBox1.Name = "richTextBox1";
            this.richTextBox1.Size = new System.Drawing.Size(100, 96);
            this.richTextBox1.TabIndex = 0;
            this.richTextBox1.Text = "";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(741, 592);
            this.Controls.Add(this.panel_bidding);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.panel_connection);
            this.Margin = new System.Windows.Forms.Padding(2);
            this.Name = "Form1";
            this.Text = "Licitations";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.panel_connection.ResumeLayout(false);
            this.panel_connection.PerformLayout();
            this.panel_bidding.ResumeLayout(false);
            this.panel_bidding.PerformLayout();
            this.panel_offers.ResumeLayout(false);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label_username;
        private System.Windows.Forms.TextBox textBox_username;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label_password;
        private System.Windows.Forms.TextBox textBox_password;
        private System.Windows.Forms.Button button_connect;
        private System.Windows.Forms.Panel panel_connection;
        private System.Windows.Forms.Panel panel_bidding;
        private System.Windows.Forms.Label label_money;
        private System.Windows.Forms.Label label_money2;
        private System.Windows.Forms.Label label_currentMoney;
        private System.Windows.Forms.Panel panel_offers;
        private System.Windows.Forms.RichTextBox richTextBox1;
        private System.Windows.Forms.Button button_disconnect;
        private System.Windows.Forms.Label label_myItems;
        private System.Windows.Forms.Label label_selectedOffer;
        private System.Windows.Forms.RichTextBox richTextBox_offer;
        private System.Windows.Forms.Button button_listOffers;
        private System.Windows.Forms.Label label_itemsOfInterest;
        private System.Windows.Forms.Button button_moneyAdd;
        private System.Windows.Forms.TextBox textBox_moneyAdd;
    }
}

