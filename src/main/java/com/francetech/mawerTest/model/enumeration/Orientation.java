package com.francetech.mawerTest.model.enumeration;

public enum Orientation {

	N {
		@Override
		public Orientation right() {
			return E;
		}

		@Override
		public Orientation left() {
			return W;
		}
	},
	E {

		@Override
		public Orientation right() {
			return S;
		}

		@Override
		public Orientation left() {
			return N;
		}
	},
	S {
		@Override
		public Orientation right() {
			return W;
		}

		@Override
		public Orientation left() {
			return E;
		}
	},
	W {

		@Override
		public Orientation right() {
			return N;
		}

		@Override
		public Orientation left() {
			return S;
		}
	};
	public abstract Orientation right();

	public abstract Orientation left();
	
	
}
