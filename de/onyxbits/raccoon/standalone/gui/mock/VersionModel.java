package de.onyxbits.raccoon.standalone.gui.mock;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

class VersionModel implements TableModel {
   public static final int COL_PACK = 0;
   public static final int COL_VER_STR = 1;
   public static final int COL_VER_CODE = 2;
   public static final String[] ROWS = new String[]{"com.android.vending", "com.google.android.gsf", "com.android.providers.downloads", "com.google.android.gms"};
   private static final String ID = VersionModel.class.getSimpleName();
   private String[] versionStrings;
   private String[] versionCodes;

   public VersionModel() {
      this.versionStrings = new String[ROWS.length];
      this.versionCodes = new String[ROWS.length];

      for(int i = 0; i < ROWS.length; ++i) {
         this.versionStrings[i] = "1";
         this.versionCodes[i] = "1";
      }

   }

   public int getRowCount() {
      return ROWS.length;
   }

   public int getColumnCount() {
      return 3;
   }

   public String getColumnName(int columnIndex) {
      switch(columnIndex) {
      case 0:
         return Messages.t(ID + ".package");
      case 1:
         return Messages.t(ID + ".versionstring");
      case 2:
         return Messages.t(ID + ".versioncode");
      default:
         throw new IllegalArgumentException();
      }
   }

   public Class getColumnClass(int columnIndex) {
      return String.class;
   }

   public boolean isCellEditable(int rowIndex, int columnIndex) {
      return columnIndex > 0;
   }

   public Object getValueAt(int rowIndex, int columnIndex) {
      switch(columnIndex) {
      case 0:
         return ROWS[rowIndex];
      case 1:
         return this.versionStrings[rowIndex];
      case 2:
         return this.versionCodes[rowIndex];
      default:
         throw new IllegalArgumentException();
      }
   }

   public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
      switch(columnIndex) {
      case 1:
         this.versionStrings[rowIndex] = aValue.toString();
         break;
      case 2:
         this.versionCodes[rowIndex] = aValue.toString();
         break;
      default:
         throw new IllegalArgumentException(columnIndex + "");
      }

   }

   public void addTableModelListener(TableModelListener l) {
   }

   public void removeTableModelListener(TableModelListener l) {
   }
}
