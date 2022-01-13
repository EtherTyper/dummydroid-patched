package de.onyxbits.raccoon.standalone.gui.about;

import de.onyxbits.raccoon.standalone.base.AppAdapter;
import de.onyxbits.raccoon.standalone.base.ModuleProvider;
import de.onyxbits.raccoon.standalone.gui.HypertextPane;
import de.onyxbits.raccoon.standalone.gui.MnemonicContext;
import de.onyxbits.raccoon.standalone.gui.SecondaryWindowController;
import de.onyxbits.raccoon.util.SemanticVersion;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

class AboutController extends SecondaryWindowController {
   private static final String ID = AboutController.class.getSimpleName();
   private JLabel title;
   private JLabel version;
   private JLabel icon;
   private HypertextPane about;
   private JButton license;
   private JButton home;

   public AboutController(ModuleProvider provider, Window owner) {
      super(provider, owner);
      SemanticVersion ver = ((AppAdapter)provider.fetch(AppAdapter.class)).getVersion();
      this.icon = new JLabel(Messages.loadIcon("appicon.png"));
      this.title = new JLabel(Messages.t(ID + ".title"));
      this.title.setFont(new Font("Dialog", 1, 20));
      this.about = (new HypertextPane(Messages.t(ID + ".about"))).withTransparency();
      this.about.setEditable(false);
      if (ver != null) {
         if (ver.isStable()) {
            this.version = new JLabel("v" + ver.major + "." + ver.minor);
         } else {
            this.version = new JLabel(ver.toString());
         }
      } else {
         this.version = new JLabel(Messages.t(ID + ".unknownversion"));
      }

      this.version.setFont(new Font("Dialog", 2, 12));
      this.license = new JButton(new LicenseAction());
      this.home = new JButton(new HomeAction(provider));
      MnemonicContext mc = new MnemonicContext();
      mc.assign(this.license);
      mc.assign(this.home);
   }

   protected JDialog createDialog(Window owner) {
      return new JDialog(owner, Messages.t(ID + ".windowtitle"));
   }

   public Container mount() {
      Container container = new JPanel(new GridBagLayout());
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = 0;
      gbc.gridy = 0;
      gbc.gridwidth = 1;
      gbc.gridheight = 2;
      gbc.fill = 0;
      gbc.insets = new Insets(4, 4, 2, 2);
      gbc.anchor = 10;
      gbc.weightx = 0.0D;
      gbc.weighty = 1.0D;
      container.add(this.icon, gbc);
      gbc.gridx = 1;
      gbc.gridy = 0;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(8, 4, 2, 2);
      gbc.anchor = 18;
      gbc.weightx = 1.0D;
      gbc.weighty = 0.0D;
      container.add(this.title, gbc);
      gbc.gridx = 1;
      gbc.gridy = 1;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(2, 8, 2, 2);
      gbc.anchor = 18;
      gbc.weightx = 1.0D;
      gbc.weighty = 0.0D;
      container.add(this.version, gbc);
      gbc.gridx = 0;
      gbc.gridy = 2;
      gbc.gridwidth = 2;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(8, 4, 2, 4);
      gbc.anchor = 18;
      gbc.weightx = 1.0D;
      gbc.weighty = 0.0D;
      container.add(this.about, gbc);
      gbc.gridx = 0;
      gbc.gridy = 4;
      gbc.gridwidth = 2;
      gbc.gridheight = 1;
      gbc.fill = 1;
      gbc.insets = new Insets(2, 2, 2, 2);
      gbc.anchor = 18;
      gbc.weightx = 1.0D;
      gbc.weighty = 0.7D;
      container.add(new JSeparator(), gbc);
      gbc.gridx = 0;
      gbc.gridy = 5;
      gbc.gridwidth = 2;
      gbc.gridheight = 1;
      gbc.fill = 0;
      gbc.insets = new Insets(2, 2, 2, 2);
      gbc.anchor = 13;
      gbc.weightx = 1.0D;
      gbc.weighty = 0.7D;
      container.add(this.mountButtons(), gbc);
      return container;
   }

   private Component mountButtons() {
      JPanel ret = new JPanel();
      ret.add(this.license);
      ret.add(this.home);
      return ret;
   }
}
