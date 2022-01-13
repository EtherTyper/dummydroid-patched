package de.onyxbits.raccoon.standalone.gui.unlock;

import de.onyxbits.raccoon.finsky.Base64G;
import de.onyxbits.raccoon.standalone.RegistrationAdapter;
import de.onyxbits.raccoon.standalone.base.AppAdapter;
import de.onyxbits.raccoon.standalone.base.ModuleProvider;
import de.onyxbits.raccoon.standalone.gui.Focus;
import de.onyxbits.raccoon.standalone.gui.HypertextPane;
import de.onyxbits.raccoon.standalone.gui.MnemonicContext;
import de.onyxbits.raccoon.standalone.gui.SecondaryWindowController;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

class ManualController extends SecondaryWindowController implements ActionListener {
   private static final String ID = ManualController.class.getSimpleName();
   private JEditorPane textPane;
   private JButton unlock;
   private JTextField key;
   private JTextField regId;
   private String title;

   public ManualController(ModuleProvider provider, Window owner, String title, String message) {
      super(provider, owner);
      this.title = title;
      this.textPane = new HypertextPane(message);
      this.textPane.setEditable(false);
      this.textPane.setMargin(new Insets(2, 2, 2, 2));
      this.textPane.setPreferredSize(new Dimension(500, 150));
      this.textPane.setCaretPosition(0);
      this.unlock = new JButton(Messages.t(ID + ".unlock"));
      (new MnemonicContext()).assign(this.unlock);
      this.key = new JTextField();
      this.key.setMargin(new Insets(2, 2, 2, 2));
      Focus.on(this.key);
      this.regId = new JTextField();
      this.regId.setEditable(false);
      this.regId.setMargin(new Insets(2, 2, 2, 2));
   }

   protected JDialog createDialog(Window owner) {
      return new JDialog(owner, this.title);
   }

   public Container mount() {
      JPanel ret = new JPanel(new GridBagLayout());
      GridBagConstraints gbc = new GridBagConstraints();
      this.key.addActionListener(this);
      this.unlock.addActionListener(this);
      gbc.gridx = 0;
      gbc.gridy = 0;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 0;
      gbc.insets = new Insets(8, 8, 0, 8);
      gbc.anchor = 18;
      gbc.weightx = 0.0D;
      gbc.weighty = 0.0D;
      ret.add(new JLabel(new ImageIcon(Messages.i("icon.png"))), gbc);
      gbc.gridx = 1;
      gbc.gridy = 0;
      gbc.gridwidth = 3;
      gbc.gridheight = 1;
      gbc.fill = 1;
      gbc.insets = new Insets(4, 4, 0, 4);
      gbc.anchor = 18;
      gbc.weightx = 1.0D;
      gbc.weighty = 1.0D;
      ret.add(new JScrollPane(this.textPane), gbc);
      gbc.gridx = 1;
      gbc.gridy = 1;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 0;
      gbc.insets = new Insets(8, 4, 4, 4);
      gbc.anchor = 17;
      gbc.weightx = 0.0D;
      gbc.weighty = 0.0D;
      ret.add(new JLabel(Messages.t(ID + ".code")), gbc);
      gbc.gridx = 2;
      gbc.gridy = 1;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 1;
      gbc.insets = new Insets(8, 4, 0, 4);
      gbc.anchor = 18;
      gbc.weightx = 1.0D;
      gbc.weighty = 0.0D;
      this.regId.setText(((RegistrationAdapter)this.fetch(RegistrationAdapter.class)).getRegistrationId().toUpperCase());
      ret.add(this.regId, gbc);
      gbc.gridx = 3;
      gbc.gridy = 1;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 1;
      gbc.insets = new Insets(8, 4, 0, 4);
      gbc.anchor = 17;
      gbc.weightx = 1.0D;
      gbc.weighty = 0.0D;
      ret.add(Box.createGlue(), gbc);
      gbc.gridx = 1;
      gbc.gridy = 2;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 0;
      gbc.insets = new Insets(8, 4, 4, 4);
      gbc.anchor = 17;
      gbc.weightx = 0.0D;
      gbc.weighty = 0.0D;
      ret.add(new JLabel(Messages.t(ID + ".key")), gbc);
      gbc.gridx = 2;
      gbc.gridy = 2;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 1;
      gbc.insets = new Insets(8, 4, 4, 4);
      gbc.anchor = 18;
      gbc.weightx = 2.0D;
      gbc.weighty = 0.0D;
      ret.add(this.key, gbc);
      gbc.gridx = 3;
      gbc.gridy = 2;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 0;
      gbc.insets = new Insets(8, 4, 4, 4);
      gbc.anchor = 18;
      gbc.weightx = 0.0D;
      gbc.weighty = 0.0D;
      ret.add(this.unlock, gbc);
      return ret;
   }

   public void actionPerformed(ActionEvent e) {
      if (this.key.getText().length() == 0) {
         this.showOffers();
      } else {
         RegistrationAdapter reg = (RegistrationAdapter)this.fetch(RegistrationAdapter.class);

         String title;
         try {
            if (!reg.updateRegistration(Base64G.decode((String)this.key.getText(), 0))) {
               throw new IllegalArgumentException();
            }

            String mes = Messages.t(ID + ".accepted.message");
            title = Messages.t(ID + ".accepted.title");
            JOptionPane.showMessageDialog(this.getWindow(), mes, title, 1);
            ((AppAdapter)this.fetch(AppAdapter.class)).exit();
         } catch (Exception var6) {
            title = ((Shop)this.fetch(Shop.class)).getOffersUrl((String)null);
            String id = reg.getRegistrationId().toUpperCase();
            this.textPane.setText(Messages.t(ID + ".invalid", id, title));
         }

      }
   }

   private void showOffers() {
      try {
         URI uri = new URI(((Shop)this.fetch(Shop.class)).getOffersUrl((String)null));
         Desktop desktop = Desktop.getDesktop();
         desktop.browse(uri);
      } catch (Exception var3) {
      }

   }
}
